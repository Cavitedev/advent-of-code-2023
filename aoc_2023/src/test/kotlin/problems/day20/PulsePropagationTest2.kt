package problems.day20

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import problems.utils.readInput

class PulsePropagationTest2 {
    lateinit var pulsePropagation: PulsePropagation


    @BeforeEach
    fun setUp() {
        pulsePropagation = PulsePropagation(readInput(("day20/it2")))
    }

    @Test
    fun pulseButton() {
        val pulseResult = pulsePropagation.pulseButton()
        assertEquals(4, pulseResult.lowPulses)
        assertEquals(4, pulseResult.highPulses)

        val pulseResult2 = pulsePropagation.pulseButton()
        assertEquals(4, pulseResult2.lowPulses)
        assertEquals(2, pulseResult2.highPulses)
    }

    @Test
    fun pulseButton1000() {
        val pulseResult = pulsePropagation.pulseButton(1000L)
        assertEquals(4250, pulseResult.lowPulses)
        assertEquals(2750, pulseResult.highPulses)

    }

}