package problems.day21

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day21Test {

    @Test
    fun part1() {
        val garden = Garden(readInput("day21/input"))
        garden.search()
        Assertions.assertEquals(3615, garden.countPlotsAtStep(64))
    }


    @Test
    fun countBySections() {
        val garden = Garden(readInput("day21/input"))
        garden.repeat(3)
        garden.search()
        Assertions.assertEquals(602259568764234L, garden.countPlotsOptimizedAtStep(26501365L))

    }

}