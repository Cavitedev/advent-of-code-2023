package problems.day10

data class SqueezePipes(val pipe1: Pipe, val pipe2: Pipe, val squeezeDirection: SqueezeDirection) {
    fun continueSqueeze(pipeMaze: PipeMaze): SqueezePipes? {

        val nextPipes = this.squeezeDirection.nextSqueeze(pipe1, pipe2, pipeMaze) ?: return null

        return SqueezePipes(nextPipes[0], nextPipes[1], squeezeDirection)


    }


}