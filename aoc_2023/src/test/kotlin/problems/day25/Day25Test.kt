package problems.day25

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day25Test {


    @Test
    fun part1() {
        val snowMachine = SnowMachine(readInput("day25/input"))
        Assertions.assertEquals(
            507626,
            snowMachine.groupDividerProduct()
        )
    }


}