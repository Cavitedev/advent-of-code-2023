package problems.day10

import java.util.*

class PipeSearch(val pipeMaze: PipeMaze) {


    fun furtherDistanceNode(): Int {

        val startPipe = pipeMaze.startPipe()
        val initNode = PipeNode(startPipe, null, 0)
        val costComparator: Comparator<PipeNode> = compareBy { it.cost }
        val nodesQueue = PriorityQueue(costComparator)
        nodesQueue.add(initNode)
        val visitedPipes = mutableSetOf(startPipe)

        var highestLength = 0

        while (!nodesQueue.isEmpty()) {
            val node = nodesQueue.poll()!!
            val neighbours = node.pipe.findNeighbours(pipeMaze)
            for (neighbour in neighbours) {
                if (visitedPipes.contains(neighbour))
                    continue
                visitedPipes.add(neighbour)
                nodesQueue.add(PipeNode(neighbour, node, node.cost + 1))
                if (node.cost + 1 >= highestLength) {
                    highestLength = node.cost + 1
                }
            }
        }

        return highestLength
    }

}