package problems.day23

import kotlin.math.max

class HikingSol(val hikingMap: HikingMap) {
    val startCell = hikingMap.startCell()
    val endCell = hikingMap.endCell()

    fun solve(): Int {
        var longestPath = 0

        val startNode = HikingNode(startCell, 0, null, mutableSetOf())

        val openedNodes = mutableListOf(startNode)

        while (openedNodes.isNotEmpty()) {
            val nextNode = openedNodes.removeLast()
            if (nextNode.cell == endCell) {
                longestPath = max(longestPath, nextNode.gCost)
                println("longest: $longestPath nodes ${openedNodes.size}")
                nextNode.removeUntilNode(openedNodes.lastOrNull()?.previousNode)
                continue
            }
            nextNode.prevCells.add(nextNode.cell)

            val neighbours = findNeighbours(nextNode).filter { neighbour ->
                neighbour.cell.canWalk && !neighbour.hasVisitedCell()
            }

            for (neighbour in neighbours) {
                openedNodes.add(neighbour)
            }

            if (neighbours.isEmpty()) {
                if (openedNodes.isEmpty()) break

                nextNode.removeUntilNode(openedNodes.lastOrNull()?.previousNode)
            }


        }

        return longestPath
    }

    fun findNeighbours(node: HikingNode): List<HikingNode> {
        val nextPos = node.cell.getNeighbours(this.hikingMap.map)
        return nextPos.map { pos ->
            val nextCell = this.hikingMap.map[pos.first][pos.second]
            node.nextNode(nextCell)
        }
    }

}