package problems.day10

class Pipe(val west: Boolean, val north: Boolean, val east: Boolean, val south: Boolean, val i: Int, val j: Int) {


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

}