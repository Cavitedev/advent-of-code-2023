package problems.day21

import problems.utils.Utils.Companion.transpose

class Garden(lines: List<String>) {

    lateinit var startPos: Pair<Int, Int>
    var originalSize = Pair(lines.size, lines[0].length)

    var cells: List<List<GardenCell>> = lines.mapIndexed { i, line ->
        line.mapIndexed { j, char ->
            when (char) {
                '#' -> {
                    GardenWallCell(i, j)
                }

                '.' -> {
                    GardenPlotCell(i, j)
                }

                'S' -> {
                    startPos = Pair(i, j)
                    GardenPlotCell(i, j)
                }

                else -> {
                    throw Exception("Impossible")
                }
            }
        }
    }

    fun countPlotsOptimizedAtStep(steps: Long): Long {

        val inputInSections = inputInSections()

        val middleSection = inputInSections[inputInSections.size / 2][inputInSections[0].size / 2]
        val maxValues =
            listOf(countPlotsAtStep(middleSection, 1000000L), countPlotsAtStep(middleSection, 1000001L)).sorted()
        val valLarge = maxValues[1]
        val secondLarge = maxValues[0]

        val edges = GardenDirection.allCartesianDirs().map { dir ->
            dir.edgeElements(inputInSections)
        }
        val edgesExpansions = edges.map {
            val last = it.first
            val secondLast = it.second
            ExpandInDirection.fromLastCellsGroups(last, secondLast, valLarge)
        }
        val edgeAmounts = edgesExpansions.sumOf { it.edgeTotalAmount(steps) }

        val corners = GardenDirection.allRomboDirs().map { dir ->
            dir.edgeElements(inputInSections)
        }
        val cornerExpansions = corners.map {
            val last = it.first
            val secondLast = it.second
            ExpandInDirection.fromLastCellsGroups(last, secondLast, valLarge)
        }
        val cornersAmounts = cornerExpansions.sumOf { it.cornerTotalAmount(steps, inputInSections.size) }


        // Inner cells
        // start dif is always the same in this problem
//        val startDif = cornerExpansions.first().startDif
        val innerEdgeAmounts = edgesExpansions.sumOf { it.innerEdgesTotalAmount(steps, valLarge, secondLarge) }
        val innerCornersAmounts =
            cornerExpansions.sumOf { it.innerCornersTotalAmount(steps, valLarge, secondLarge, inputInSections.size) }

        val currentCells = countPlotsAtStep(cells, steps)



// 1986 + 154 + 946 + 648 + 2802
        return currentCells + edgeAmounts + cornersAmounts + innerEdgeAmounts + innerCornersAmounts
    }

    fun countPlotsAtStep(step: Long): Int {
        return countPlotsAtStep(cells, step)
    }

    companion object {
        fun countPlotsAtStep(cells: List<List<GardenCell>>, step: Long): Int {
            val reachableCells = cells.flatten().filter { cell ->
                if (cell !is GardenPlotCell) {
                    return@filter false
                }
                cell.isInStep(step)
            }

            return reachableCells.size
        }

        fun firstStep(cells: List<List<GardenCell>>): Int {
            return cells.minOf {
                it.mapNotNull { cell ->
                    if (cell !is GardenPlotCell) {
                        null
                    } else {
                        cell.firstStep
                    }
                }.min()
            }
        }
    }


    fun countBySections(times: Long): List<List<Int>> {
        val divididedInput = this.cells.map { line -> line.chunked(originalSize.second) }.transpose()
            .map { it.chunked(originalSize.first) }

        return divididedInput.map { rowComb -> rowComb.map { gridComb -> countPlotsAtStep(gridComb, times) } }
    }

    fun inputInSections(): List<List<List<List<GardenCell>>>> {
        return this.cells.map { line -> line.chunked(originalSize.second) }.transpose()
            .map { it.chunked(originalSize.first) }
    }


    fun extractAllSquares(originalMatrix: List<List<Any>>, size: Int): List<List<List<Any>>> {
        val submatrices = mutableListOf<List<List<Any>>>()

        for (rowStart in 0..originalMatrix.size - size) {
            for (colStart in 0..originalMatrix[0].size - size) {
                val submatrix = (0 until size).map { i ->
                    originalMatrix[rowStart + i].subList(colStart, colStart + size)
                }
                submatrices.add(submatrix)
            }
        }

        return submatrices
    }


    fun search() {
        val startNode = GardenNode(0, this.cells[startPos.first][startPos.second])

        val openedCells = mutableListOf(startNode)
        while (openedCells.isNotEmpty()) {
            val nextNode = openedCells.removeAt(0)
            val nextCell = nextNode.cell
            if (!nextCell.canWalk()) continue
            val plotCell = nextCell as GardenPlotCell
            if (plotCell.firstStep != null) continue
            plotCell.firstStep = nextNode.step

            val neighbours = findNeighbours(nextNode)
            for (neighbour in neighbours) {
                openedCells.add(neighbour)
            }

        }
    }

    fun findNeighbours(node: GardenNode): List<GardenNode> {
        val cell = node.cell
        val neighbours = GardenDirection.allCartesianDirs().map { dir ->
            val nextPos = dir.nextPos(cell.i, cell.j, this.cells)
            if (nextPos != null) {
                val nextCell = this.cells[nextPos.first][nextPos.second]
                return@map GardenNode(node.step + 1, nextCell)
            } else {
                return@map null
            }
        }

        return neighbours.filterNotNull()

    }

    fun repeat(times: Int) {
        val actualTimes = (times * 2 + 1)
        val width = this.cells.size
        val height = this.cells[0].size

        val repeatedWidth = this.cells.map { lineCell ->
            List(actualTimes) { lineCell.map { it.copy() } }.flatten()
        }
        val repeatedHeight = List(actualTimes) { repeatedWidth.map { line -> line.map { it.copy() } } }.flatten()

        startPos = Pair(startPos.first + width * times, startPos.second + height * times)

        for (i in repeatedHeight.indices) {
            for (j in repeatedHeight[0].indices) {
                repeatedHeight[i][j].i = i
                repeatedHeight[i][j].j = j
            }
        }

        this.cells = repeatedHeight

    }

    fun getPrintLines(step: Long): String {
        return this.cells.joinToString("\n") { lineCell -> lineCell.map { it.characterMap(step) }.joinToString("") }
    }

}