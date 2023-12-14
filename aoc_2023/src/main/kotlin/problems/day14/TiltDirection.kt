package problems.day14

abstract class TiltDirection {

    abstract fun tilt(lines: List<String>): List<String>

}

class NorthTiltDirection : TiltDirection() {
    companion object {
        private var instance: TiltDirection? = null

        fun getInstance(): TiltDirection {
            if (instance == null) {
                instance = NorthTiltDirection()
            }
            return instance!!
        }
    }

    override fun tilt(lines: List<String>): List<String> {


        val moveLimit = MutableList(lines[0].length) { 0 }

        val output = lines.map { it.toCharArray() }

        for (i in lines.indices) {
            val line = lines[i]
            for (j in line.indices) {
                when (line[j]) {
                    'O' -> {
                        val curMove = moveLimit[j]
                        output[i][j] = '.'
                        output[curMove][j] = 'O'
                        moveLimit[j] += 1
                    }

                    '#' -> {
                        moveLimit[j] = i + 1
                    }

                    else -> {}
                }
            }
        }
        return output.map { String(it) }

    }
}