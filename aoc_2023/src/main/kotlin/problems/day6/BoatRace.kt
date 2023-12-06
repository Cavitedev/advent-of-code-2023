package problems.day6

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.pow

data class BoatRace(val time: Long, val recordDistance: Long) {

    fun waysOfBeatingRecord(): Long {

        val squareOp = (time.toDouble().pow(2) - 4 * recordDistance).pow(0.5)

        val minTimeResult = ((time - squareOp) / 2.0)
        val minTime = if (minTimeResult % 1 != 0.0) ceil(minTimeResult) else minTimeResult + 1.0
        val maxTimeResult = ((time + squareOp) / 2.0)
        val maxTime = if (maxTimeResult % 1 != 0.0) floor(maxTimeResult) else maxTimeResult - 1.0

        return (maxTime - minTime + 1).toLong()
    }

}