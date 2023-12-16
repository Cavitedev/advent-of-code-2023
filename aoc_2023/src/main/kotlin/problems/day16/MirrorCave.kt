package problems.day16

import problems.day16.cells.MirrorCellType

class MirrorCave(lines: List<String>) {

    val grid: List<List<MirrorCellType>> = lines.map { line ->
        line.map { char ->
            MirrorCellType.fromChar(char)
        }
    }

    fun energizedBeansTopLeft(): Int {
        return energizedBeans(BeamNode(0, -1, EastBeamDir.getInstance())) - 1
    }

    fun energizedBeans(startNode: BeamNode): Int {

        val visitedCells = mutableSetOf(Pair(0, 0))
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

        return visitedCells.size
    }

}