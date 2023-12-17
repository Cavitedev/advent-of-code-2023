package problems.day17

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day17Test {

    @Test
    fun part1() {
        val city = CrucibleCity(readInput("day17/input"))
        Assertions.assertEquals(859, city.minimumHeastLoss())
    }

    @Test
    fun part2() {
        val city = CrucibleCity(readInput("day17/input"))
        Assertions.assertEquals(1027, city.minimumHeastLossUltraCrucible())
    }


}