package problems.day8

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import problems.utils.readInput

class GhostDesertMapTest {

    lateinit var desertMap: DesertMap

    @BeforeEach
    fun setUp() {
        desertMap = DesertMap(readInput("day8/input_test2"))
    }


    @Test
    fun ghostSolutions() {
        assertEquals(
            listOf(
                GhostMapSolution(startSite = "11A", startIndex = 0, endSite = "11Z", endIndex = 2),
                GhostMapSolution(startSite = "11Z", startIndex = 2, endSite = "11Z", endIndex = 4)
            ), desertMap.ghostSolutions("11A")
        )
    }

    @Test
    fun checkGhostStepsSolution() {
        val ghostDesertMap = DesertMap(readInput("day8/input_test2"))
        assertEquals(6, ghostDesertMap.ghostStepsSolution())
    }
}