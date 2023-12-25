package problems.day25

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import problems.utils.readInput

class SnowMachineTest {

    lateinit var snowMachine: SnowMachine

    @BeforeEach
    fun setUp() {
        snowMachine = SnowMachine(readInput("day25/it1"))
    }

    @Test
    fun getComponents() {
        assertEquals(15, snowMachine.components.size)
        assertEquals(true, snowMachine.components["rhn"]!!.otherComponents.any { it.name == "jqt" })
    }

    @Test
    fun groupDivider() {
        assertEquals(54, snowMachine.groupDividerProduct())
    }
}