package problems.day10

//enum class SqueezeDirection{
//    NORTH, EAST, SOUTH, WEST
//}

abstract class SqueezeDirection {


    abstract fun neighbour(pipe: Pipe, pipeMaze: PipeMaze): Pipe?
    abstract fun neighbours(squeezePipe: SqueezePipes, pipeMaze: PipeMaze): List<SqueezePipes>


    abstract fun checkSqueeze(pipe1: Pipe, pipe2: Pipe): Boolean
    fun checkSqueeze(squeezePipe: SqueezePipes): Boolean {
        return checkSqueeze(squeezePipe.pipe1, squeezePipe.pipe2)
    }

    fun nextSqueeze(squeezePipe: SqueezePipes, pipeMaze: PipeMaze): List<SqueezePipes> {
        if (!checkSqueeze(squeezePipe)) return listOf()
        val nextPipes = neighbours(squeezePipe, pipeMaze)
        return nextPipes
    }


}

class WestSqueezeDirection : SqueezeDirection() {

    companion object {
        private var instance: SqueezeDirection? = null

        fun getInstance(): SqueezeDirection {
            if (instance == null) {
                instance = WestSqueezeDirection()
            }
            return instance!!
        }
    }

    override fun neighbour(pipe: Pipe, pipeMaze: PipeMaze): Pipe? {
        if (pipe.j == 0) return null
        return pipeMaze.maze[pipe.i][pipe.j - 1]
    }

    override fun neighbours(squeezePipe: SqueezePipes, pipeMaze: PipeMaze): List<SqueezePipes> {
        val neighbour1 = neighbour(squeezePipe.pipe1, pipeMaze)
        val neighbour2 = neighbour(squeezePipe.pipe2, pipeMaze)
        if (neighbour1 == null || neighbour2 == null) return listOf()
        return listOf(
            SqueezePipes(neighbour1, neighbour2, this),
            SqueezePipes(neighbour1, squeezePipe.pipe1, NorthSqueezeDirection.getInstance()),
            SqueezePipes(neighbour2, squeezePipe.pipe2, SouthSqueezeDirection.getInstance())
        )
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

    companion object {
        private var instance: SqueezeDirection? = null

        fun getInstance(): SqueezeDirection {
            if (instance == null) {
                instance = NorthSqueezeDirection()
            }
            return instance!!
        }
    }

    override fun neighbour(pipe: Pipe, pipeMaze: PipeMaze): Pipe? {
        if (pipe.i == 0) return null
        return pipeMaze.maze[pipe.i - 1][pipe.j]
    }

    override fun neighbours(squeezePipe: SqueezePipes, pipeMaze: PipeMaze): List<SqueezePipes> {
        val neighbour1 = neighbour(squeezePipe.pipe1, pipeMaze)
        val neighbour2 = neighbour(squeezePipe.pipe2, pipeMaze)
        if (neighbour1 == null || neighbour2 == null) return listOf()
        return listOf(
            SqueezePipes(neighbour1, neighbour2, this),
            SqueezePipes(neighbour1, squeezePipe.pipe1, WestSqueezeDirection.getInstance()),
            SqueezePipes(neighbour2, squeezePipe.pipe2, EastSqueezeDirection.getInstance())
        )
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

    companion object {
        private var instance: SqueezeDirection? = null

        fun getInstance(): SqueezeDirection {
            if (instance == null) {
                instance = EastSqueezeDirection()
            }
            return instance!!
        }
    }

    override fun neighbour(pipe: Pipe, pipeMaze: PipeMaze): Pipe? {
        if (pipe.j == pipeMaze.maze[0].size - 1) return null
        return pipeMaze.maze[pipe.i][pipe.j + 1]
    }

    override fun neighbours(squeezePipe: SqueezePipes, pipeMaze: PipeMaze): List<SqueezePipes> {
        val neighbour1 = neighbour(squeezePipe.pipe1, pipeMaze)
        val neighbour2 = neighbour(squeezePipe.pipe2, pipeMaze)
        if (neighbour1 == null || neighbour2 == null) return listOf()
        return listOf(
            SqueezePipes(neighbour1, neighbour2, this),
            SqueezePipes(squeezePipe.pipe1, neighbour1, NorthSqueezeDirection.getInstance()),
            SqueezePipes(squeezePipe.pipe2, neighbour2, SouthSqueezeDirection.getInstance())
        )
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

    companion object {
        private var instance: SqueezeDirection? = null

        fun getInstance(): SqueezeDirection {
            if (instance == null) {
                instance = SouthSqueezeDirection()
            }
            return instance!!
        }
    }

    override fun neighbour(pipe: Pipe, pipeMaze: PipeMaze): Pipe? {
        if (pipe.i == pipeMaze.maze.size - 1) return null
        return pipeMaze.maze[pipe.i + 1][pipe.j]
    }

    override fun neighbours(squeezePipe: SqueezePipes, pipeMaze: PipeMaze): List<SqueezePipes> {
        val neighbour1 = neighbour(squeezePipe.pipe1, pipeMaze)
        val neighbour2 = neighbour(squeezePipe.pipe2, pipeMaze)
        if (neighbour1 == null || neighbour2 == null) return listOf()
        return listOf(
            SqueezePipes(neighbour1, neighbour2, this),
            SqueezePipes(squeezePipe.pipe1, neighbour1, WestSqueezeDirection.getInstance()),
            SqueezePipes(squeezePipe.pipe2, neighbour2, EastSqueezeDirection.getInstance())
        )
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