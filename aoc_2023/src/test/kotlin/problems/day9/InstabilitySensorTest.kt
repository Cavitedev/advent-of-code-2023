package problems.day9

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import problems.utils.readInput

class InstabilitySensorTest {

    lateinit var instabilitySensor: InstabilitySensor

    @BeforeEach
    fun setUp() {
        instabilitySensor = InstabilitySensor(readInput("day9/input_test"))
    }

    @Test
    fun getLines() {
        assertEquals(3, instabilitySensor.lines.count())
        assertEquals(SensorLine(listOf(0L, 3L, 6L, 9L, 12L, 15L)), instabilitySensor.lines.first())
    }

    @Test
    fun sumExtrapolatedForwardNumbers() {
        assertEquals(114L, instabilitySensor.sumExtrapolatedForwardNumbers())
    }

    @Test
    fun sumExtrapolatedBackwardNumbers() {
        assertEquals(2L, instabilitySensor.sumExtrapolatedBackwardNumbers())
    }
}