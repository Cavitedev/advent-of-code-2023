package problems.day6

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day6Test {

    @Test
    fun part1() {
        val races = BoatRaces.fromLines(readInput("day6/input"))
        Assertions.assertEquals(138915, races.waysOfBeatingRecordsProduct())
    }

    @Test
    fun part2() {
        val races = BoatRaces.fromRightKerningLines(readInput("day6/input"))
        Assertions.assertEquals(27340847, races.waysOfBeatingRecordsProduct())
    }

}