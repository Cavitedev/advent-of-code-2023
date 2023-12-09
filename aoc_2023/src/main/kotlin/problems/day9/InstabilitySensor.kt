package problems.day9

import Utils

class InstabilitySensor {
    val lines: List<SensorLine>

    constructor(input: List<String>) {
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