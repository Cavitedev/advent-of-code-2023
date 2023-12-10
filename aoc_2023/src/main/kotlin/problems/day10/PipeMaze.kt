package problems.day10

import java.util.*

class PipeMaze() {
    lateinit var maze: List<List<Pipe>>
    lateinit var mainLoop: Set<Pipe>
    lateinit var startPipe: Pipe

    constructor(lines: List<String>) : this() {
        this.maze = lines.mapIndexed { i, line ->
            line.mapIndexed { j, char ->
                when (char) {
                    '|' -> {
                        Pipe(false, true, false, true, i, j)
                    }

                    '-' -> {
                        Pipe(true, false, true, false, i, j)
                    }

                    'L' -> {
                        Pipe(false, true, true, false, i, j)
                    }

                    'J' -> {
                        Pipe(true, true, false, false, i, j)
                    }

                    '7' -> {
                        Pipe(true, false, false, true, i, j)
                    }

                    'F' -> {
                        Pipe(false, false, true, true, i, j)
                    }

                    '.' -> {
                        Pipe(false, false, false, false, i, j)
                    }

                    'S' -> {
                        Pipe(true, true, true, true, i, j)
                    }

                    else -> {
                        Pipe(false, false, false, false, i, j)
                    }
                }
            }
        }
        val startPipe = maze.flatten().find { it.north && it.east && it.south && it.west }!!
        startPipe.closeUnconnectedConnections(this)
        this.startPipe = startPipe

        this.mainLoop = calcMainLoop()
    }


    private fun calcMainLoop(): Set<Pipe> {

        val startPipe = startPipe
        val initNode = PipeNode(startPipe, null, 0)
        val costComparator: Comparator<PipeNode> = compareBy { it.cost }
        val nodesQueue = PriorityQueue(costComparator)
        nodesQueue.add(initNode)
        val visitedPipes = mutableSetOf(startPipe)


        while (!nodesQueue.isEmpty()) {
            val node = nodesQueue.poll()!!
            val neighbours = node.pipe.findNeighbours(this)
            for (neighbour in neighbours) {
                if (visitedPipes.contains(neighbour))
                    continue
                visitedPipes.add(neighbour)
                nodesQueue.add(PipeNode(neighbour, node, node.cost + 1))

            }
        }

        return visitedPipes
    }

    fun furtherstDistanceNode(): Int {
        return mainLoop.size / 2
    }

    fun innerTilesCount(): Int {
        val search = PipeSearch(this)
        return (this.maze.size * this.maze[0].size) - this.mainLoop.size - search.outerTiles().size
    }


}