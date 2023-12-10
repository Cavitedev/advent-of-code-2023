package problems.day10

class Pipe(var west: Boolean, var north: Boolean, var east: Boolean, var south: Boolean, val i: Int, val j: Int) {

    fun getAllNeighbours(pipeMaze: PipeMaze): List<Pipe> {
        val pipesFound = mutableListOf<Pipe>()

        if (j != 0) {
            val pipe = pipeMaze.maze[i][j - 1]
            pipesFound.add(pipe)
        }
        if (i != 0) {
            val pipe = pipeMaze.maze[i - 1][j]
            pipesFound.add(pipe)
        }

        if (j != pipeMaze.maze[0].size - 1) {
            val pipe = pipeMaze.maze[i][j + 1]
            pipesFound.add(pipe)
        }

        if (i != pipeMaze.maze.size - 1) {
            val pipe = pipeMaze.maze[i + 1][j]
            pipesFound.add(pipe)
        }

        return pipesFound
    }

    fun findNeighbours(pipeMaze: PipeMaze): List<Pipe> {

        val pipesFound = mutableListOf<Pipe>()

        if (west && j != 0) {
            val pipe = pipeMaze.maze[i][j - 1]
            if (pipe.east)
                pipesFound.add(pipe)
        }
        if (north && i != 0) {
            val pipe = pipeMaze.maze[i - 1][j]
            if (pipe.south)
                pipesFound.add(pipe)
        }

        if (east && j != pipeMaze.maze[0].size - 1) {
            val pipe = pipeMaze.maze[i][j + 1]
            if (pipe.west)
                pipesFound.add(pipe)
        }

        if (south && i != pipeMaze.maze.size - 1) {
            val pipe = pipeMaze.maze[i + 1][j]
            if (pipe.north)
                pipesFound.add(pipe)
        }

        return pipesFound
    }

    fun getSqueezePipes(pipeMaze: PipeMaze): List<SqueezePipes> {
        val squeeze = mutableListOf<SqueezePipes>()

        // Left
        if (j != 0) {
            val leftNeighbour = pipeMaze.maze[i][j - 1]
            if (i != 0) {
                val northLeftNeighbour = pipeMaze.maze[i - 1][j - 1]
                squeeze.add(SqueezePipes(northLeftNeighbour, leftNeighbour, WestSqueezeDirection()))
            }

            if (i != pipeMaze.maze.size - 1) {
                val southLeftNeighbour = pipeMaze.maze[i + 1][j - 1]
                squeeze.add(SqueezePipes(leftNeighbour, southLeftNeighbour, WestSqueezeDirection()))
            }
        }
        // Right
        if (j != pipeMaze.maze[0].size - 1) {
            val rightNeighbour = pipeMaze.maze[i][j + 1]
            if (i != 0) {
                val northRightNeighbour = pipeMaze.maze[i - 1][j + 1]
                squeeze.add(SqueezePipes(rightNeighbour, northRightNeighbour, EastSqueezeDirection()))
            }

            if (i != pipeMaze.maze.size - 1) {
                val southRightNeighbour = pipeMaze.maze[i + 1][j + 1]
                squeeze.add(SqueezePipes(rightNeighbour, southRightNeighbour, EastSqueezeDirection()))
            }
        }
        // Up
        if (i != 0) {
            val northNeighbour = pipeMaze.maze[i - 1][j]
            if (j != 0) {
                val northLeftNeighbour = pipeMaze.maze[i - 1][j - 1]
                squeeze.add(SqueezePipes(northLeftNeighbour, northNeighbour, NorthSqueezeDirection()))
            }

            if (j != pipeMaze.maze[0].size - 1) {
                val northRightNeighbour = pipeMaze.maze[i - 1][j + 1]
                squeeze.add(SqueezePipes(northNeighbour, northRightNeighbour, NorthSqueezeDirection()))
            }
        }

        // South
        if (i != pipeMaze.maze.size - 1) {
            val southNeighbour = pipeMaze.maze[i + 1][j]
            if (j != 0) {
                val southLeftNeighbour = pipeMaze.maze[i + 1][j - 1]
                squeeze.add(SqueezePipes(southLeftNeighbour, southNeighbour, SouthSqueezeDirection()))
            }

            if (j != pipeMaze.maze[0].size - 1) {
                val southRightNeighbour = pipeMaze.maze[i + 1][j + 1]
                squeeze.add(SqueezePipes(southNeighbour, southRightNeighbour, SouthSqueezeDirection()))
            }
        }

        return squeeze

    }

    fun closeUnconnectedConnections(pipeMaze: PipeMaze) {
        val neighbours = findNeighbours(pipeMaze)
        if (west && !neighbours.any { it.j == this.i - 1 }) {
            west = false
        }
        if (north && !neighbours.any { it.i == this.i - 1 }) {
            north = false
        }
        if (east && !neighbours.any { it.j == this.j + 1 }) {
            east = false
        }
        if (south && !neighbours.any { it.i == this.i + 1 }) {
            south = false
        }


    }

    override fun toString(): String {
        return "($i,$j)"
    }

}