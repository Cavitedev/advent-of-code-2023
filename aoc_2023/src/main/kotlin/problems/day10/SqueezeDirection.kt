package problems.day10

//enum class SqueezeDirection{
//    NORTH, EAST, SOUTH, WEST
//}

abstract class SqueezeDirection {
    abstract fun neighbour(pipe: Pipe, pipeMaze: PipeMaze): Pipe?

    abstract fun checkSqueeze(pipe1: Pipe, pipe2: Pipe): Boolean
    fun nextSqueeze(pipe1: Pipe, pipe2: Pipe, pipeMaze: PipeMaze): List<Pipe>? {
        if (!checkSqueeze(pipe1, pipe2)) return null
        val nextPipe1 = neighbour(pipe1, pipeMaze)
        val nextPipe2 = neighbour(pipe2, pipeMaze)
        if (nextPipe1 == null || nextPipe2 == null) return null
        return listOf(nextPipe1, nextPipe2)
    }


}

class WestSqueezeDirection : SqueezeDirection() {
    override fun neighbour(pipe: Pipe, pipeMaze: PipeMaze): Pipe? {
        if (pipe.j == 0) return null
        return pipeMaze.maze[pipe.i][pipe.j - 1]
    }

    override fun checkSqueeze(pipe1: Pipe, pipe2: Pipe): Boolean {
        return !pipe1.south && !pipe2.north
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is WestSqueezeDirection) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }


}

class NorthSqueezeDirection : SqueezeDirection() {
    override fun neighbour(pipe: Pipe, pipeMaze: PipeMaze): Pipe? {
        if (pipe.i == 0) return null
        return pipeMaze.maze[pipe.i - 1][pipe.j]
    }

    override fun checkSqueeze(pipe1: Pipe, pipe2: Pipe): Boolean {
        return !pipe1.east && !pipe2.west
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is NorthSqueezeDirection) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }


}

class EastSqueezeDirection : SqueezeDirection() {
    override fun neighbour(pipe: Pipe, pipeMaze: PipeMaze): Pipe? {
        if (pipe.j == pipeMaze.maze[0].size - 1) return null
        return pipeMaze.maze[pipe.i][pipe.j + 1]
    }

    override fun checkSqueeze(pipe1: Pipe, pipe2: Pipe): Boolean {
        return !pipe1.south && !pipe2.north
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is EastSqueezeDirection) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }


}

class SouthSqueezeDirection : SqueezeDirection() {
    override fun neighbour(pipe: Pipe, pipeMaze: PipeMaze): Pipe? {
        if (pipe.i == pipeMaze.maze.size - 1) return null
        return pipeMaze.maze[pipe.i + 1][pipe.j]
    }

    override fun checkSqueeze(pipe1: Pipe, pipe2: Pipe): Boolean {
        return !pipe1.east && !pipe2.west
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SouthSqueezeDirection) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }


}