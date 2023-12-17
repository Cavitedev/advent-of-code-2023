package problems.day16

import problems.day16.cells.MirrorCellType

class MirrorCave(lines: List<String>) {

    val grid: List<List<MirrorCellType>> = lines.map { line ->
        line.map { char ->
            MirrorCellType.fromChar(char)
        }
    }

    fun energizedBeansTopLeft(): Int {
        return energizedBeans(BeamNode(0, -1, EastBeamDir.getInstance()))
    }

    fun bestEnergizedBeanAllDirs(): Int {
        val initBeans = mutableListOf<BeamNode>()
        for (i in grid.indices) {
            initBeans.add(BeamNode(i, -1, EastBeamDir.getInstance()))
            initBeans.add(BeamNode(i, grid[0].size, WestBeamDir.getInstance()))
        }

        for (j in grid[0].indices) {
            initBeans.add(BeamNode(-1, j, SouthBeamDir.getInstance()))
            initBeans.add(BeamNode(grid.size, j, NorthBeamDir.getInstance()))
        }

        // Parallel code
        val results = initBeans.parallelStream().map { energizedBeans(it) }.toList()
        return results.max()
    }

    fun energizedBeans(startNode: BeamNode): Int {

        val visitedCells = mutableSetOf<Pair<Int, Int>>()
        val visitedNodes: MutableSet<BeamNode> = mutableSetOf()
        val activeBeans = mutableListOf(startNode)

        while (activeBeans.isNotEmpty()) {
            val curBeam = activeBeans.removeFirst()
            if (visitedNodes.contains(curBeam)) continue
            visitedNodes.add(curBeam)
            visitedCells.add(Pair(curBeam.i, curBeam.j))
            val nextBeans = curBeam.nextNodes(this)
            activeBeans.addAll(0, nextBeans)
        }

        return visitedCells.size - 1
    }

}