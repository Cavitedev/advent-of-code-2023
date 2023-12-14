package problems.day14

import problems.utils.Utils.Companion.rotateAnticlockwise
import problems.utils.Utils.Companion.rotateClockwise

abstract class TiltDirection {

    abstract fun tilt(lines: List<List<Char>>): List<List<Char>>

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

    override fun tilt(lines: List<List<Char>>): List<List<Char>> {


        val moveLimit = MutableList(lines[0].size) { 0 }

        val output = lines.map { it.toMutableList() }

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
        return output

    }
}


class EastTiltDirection : TiltDirection() {
    companion object {
        private var instance: TiltDirection? = null

        fun getInstance(): TiltDirection {
            if (instance == null) {
                instance = EastTiltDirection()
            }
            return instance!!
        }
    }

    override fun tilt(lines: List<List<Char>>): List<List<Char>> {

        val rotatedInput = lines.rotateClockwise()
        return SouthTiltDirection.getInstance().tilt(rotatedInput).rotateAnticlockwise()

    }
}

class WestTiltDirection : TiltDirection() {
    companion object {
        private var instance: TiltDirection? = null

        fun getInstance(): TiltDirection {
            if (instance == null) {
                instance = WestTiltDirection()
            }
            return instance!!
        }
    }

    override fun tilt(lines: List<List<Char>>): List<List<Char>> {

        val rotatedInput = lines.rotateClockwise()
        return NorthTiltDirection.getInstance().tilt(rotatedInput).rotateAnticlockwise()

    }
}

class SouthTiltDirection : TiltDirection() {
    companion object {
        private var instance: TiltDirection? = null

        fun getInstance(): TiltDirection {
            if (instance == null) {
                instance = SouthTiltDirection()
            }
            return instance!!
        }
    }

    override fun tilt(lines: List<List<Char>>): List<List<Char>> {
        val rotatedInput = lines.rotateClockwise()
        return WestTiltDirection.getInstance().tilt(rotatedInput).rotateAnticlockwise()
    }
}