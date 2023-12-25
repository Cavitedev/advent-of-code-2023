package problems.day25

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day25Test {


    @Test
    fun part1() {
        val snowMachine = SnowMachine(readInput("day25/input"))
        // 507644 Too high
        Assertions.assertEquals(
            24627,
            snowMachine.groupDividerProduct()
        )
    }


}