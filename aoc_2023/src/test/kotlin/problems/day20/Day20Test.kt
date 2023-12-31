package problems.day20

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day20Test {

    @Test
    fun part1() {
        val pulsePropagation = PulsePropagation(readInput("day20/input"))
        val buttonResult = pulsePropagation.pulseButton(1000)
        val res = buttonResult.highPulses * buttonResult.lowPulses
        Assertions.assertEquals(808146535L, res)
    }

    @Test
    fun part2() {
        val pulsePropagation = PulsePropagation(readInput("day20/input"))

        Assertions.assertEquals(224602953547789L, pulsePropagation.countUntilRx())
    }


}