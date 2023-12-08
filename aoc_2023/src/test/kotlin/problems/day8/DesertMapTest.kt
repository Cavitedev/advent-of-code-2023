package problems.day8

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import problems.utils.readInput

class DesertMapTest {

    lateinit var desertMap: DesertMap

    @BeforeEach
    fun setUp() {
        desertMap = DesertMap(readInput("day8/input_test"))
    }

    @Test
    fun readLinesWorked() {
        assertEquals(listOf(0, 0, 1), desertMap.directions)
        assertEquals(3, desertMap.connections.count())
        assertEquals(Pair("BBB", "BBB"), desertMap.connections["AAA"])
    }


    @Test
    fun checkStepsSolution() {
        assertEquals(6, desertMap.stepsSolution())
    }

}