package problems.day10

data class SqueezePipes(val pipe1: Pipe, val pipe2: Pipe, val squeezeDirection: SqueezeDirection) {
    fun continueSqueeze(pipeMaze: PipeMaze): List<SqueezePipes> {

        val nextPipes = this.squeezeDirection.nextSqueeze(this, pipeMaze)

        return nextPipes


    }


}