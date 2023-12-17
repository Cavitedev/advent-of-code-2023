package problems.day17

import java.util.*

open class CrucibleSearch(val city: CrucibleCity) {

    fun minimumHeastLoss(): Int {

        val node1 = CrucibleNode(0, 1, city.grid[0][1], hCost(0, 1), EastCrucibleDir.getInstance(), null)
        val node2 = CrucibleNode(1, 0, city.grid[1][0], hCost(1, 0), SouthCrucibleDir.getInstance(), null)

        val openedNodes = PriorityQueue<CrucibleNode> { a, b -> a.fCost - b.fCost }
        val visitedStates = mutableSetOf<CrucibleNode>()
        openedNodes.add(node1)
        openedNodes.add(node2)

        var openedNodesCount = 0

        while (openedNodes.isNotEmpty()) {
            openedNodesCount++
            val nextNode = openedNodes.poll()

            if (isGoal(nextNode)) {
                println(openedNodesCount)
                return nextNode.gCost
            }

            if (visitedStates.contains(nextNode)) continue
            visitedStates.add(nextNode)

            val successors = getSuccessors(nextNode)
            openedNodes.addAll(successors)
        }
        return -1
    }

    fun hCost(i: Int, j: Int): Int {
        return this.city.grid.size - 1 - i + this.city.grid[0].size - 1 - j
    }

    fun getSuccessors(node: CrucibleNode): List<CrucibleNode> {

        val nextDirs = nextDirs(node)

        val nextNodes = nextDirs.mapNotNull { dir ->
            val nextPos = dir.nextPos(node.i, node.j, this.city.grid)
            if (nextPos != null) {
                node.generateNextNode(
                    nextPos.first,
                    nextPos.second,
                    this.city.grid[nextPos.first][nextPos.second],
                    hCost(nextPos.first, nextPos.second),
                    dir
                )
            } else {
                null
            }
        }

        return nextNodes
    }

    open fun nextDirs(node: CrucibleNode): List<CrucibleDirection> {
        val nextDirs = mutableListOf(node.dir.rotateAntiClockwise(), node.dir.rotateClockwise())
        if (node.repeatedDirs < 3) {
            nextDirs.add(node.dir)
        }
        return nextDirs
    }

    open fun isGoal(node: CrucibleNode): Boolean {
        return node.i == this.city.grid.size - 1 && node.j == this.city.grid[0].size - 1
    }

}