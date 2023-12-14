package problems.day9

import problems.utils.Utils

class InstabilitySensor(input: List<String>) {
    val lines: List<SensorLine>

    init {
        this.lines = input.map { SensorLine(Utils.numbersInLineString(it)) }
    }

    fun sumExtrapolatedForwardNumbers(): Long {
        return this.lines.fold(0) { acc, line ->
            acc + line.extrapolateForward()
        }
    }

    fun sumExtrapolatedBackwardNumbers(): Long {
        return this.lines.fold(0) { acc, line ->
            acc + line.extrapolateBackward()
        }
    }

}