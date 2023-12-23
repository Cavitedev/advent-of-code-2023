package problems.day23

import kotlin.math.max

class HikingSol(val hikingMap: HikingMap) {
    val startCell = hikingMap.startCell()
    val endCell = hikingMap.endCell()

    fun solve(): Int {
        var longestPath = 0

        val startNode = HikingNode(startCell, 0, null)

        val openedNodes = mutableListOf(startNode)

        while (openedNodes.isNotEmpty()) {
            val nextNode = openedNodes.removeLast()
            if (!nextNode.cell.canWalk) continue
            if (nextNode.hasVisitedCell()) continue
            if (nextNode.cell == endCell) {
                longestPath = max(longestPath, nextNode.gCost)
            }

            val neighbours = findNeighbours(nextNode)

            for (neighbour in neighbours) {
                openedNodes.add(neighbour)
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