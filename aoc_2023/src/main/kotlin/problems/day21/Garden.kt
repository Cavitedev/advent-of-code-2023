package problems.day21

class Garden(lines: List<String>) {

    lateinit var startPos: Pair<Int, Int>

    val cells: List<List<GardenCell>> = lines.mapIndexed { i, line ->
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

    fun countPlotsAtStep(step: Long): Int {
        val reachableCells = this.cells.flatten().filter {
            if (it !is GardenPlotCell) {
                return@filter false
            }
            val plotCell = it
            if (plotCell.firstStep == null) {
                return@filter false
            }
            val firstStep = plotCell.firstStep!!.toLong()
            if (firstStep <= step && firstStep % 2 == step % 2) {
                return@filter true
            }
            false
        }

        return reachableCells.size
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
        val neighbours = GardenDirection.allDirs().map { dir ->
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

}