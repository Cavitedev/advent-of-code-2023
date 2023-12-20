package problems.day20

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import problems.utils.readInput

class PulsePropagationTest {
    lateinit var pulsePropagation: PulsePropagation


    @BeforeEach
    fun setUp() {
        pulsePropagation = PulsePropagation(readInput(("day20/it1")))
    }

    @Test
    fun getModules() {
        assertEquals(5, pulsePropagation.modules.size)
        val inv = pulsePropagation.modules["inv"] as ConjuctionModule
        assertEquals(Signal.LOW, inv.dependantModules.first().lastSignal)
    }

    @Test
    fun pulseButton() {
        val pulseResult = pulsePropagation.pulseButton()
        assertEquals(8, pulseResult.lowPulses)
        assertEquals(4, pulseResult.highPulses)
    }

    @Test
    fun pulseButton1000() {
        val pulseResult = pulsePropagation.pulseButton(1000L)
        assertEquals(8000, pulseResult.lowPulses)
        assertEquals(4000, pulseResult.highPulses)

    }

}

