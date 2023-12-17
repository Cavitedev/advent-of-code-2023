package problems.day17

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import problems.utils.readInput

class Day17Test {

    @Test
    fun part1() {
        // BFS 615249 opened nodes
        // A*  565086 opened nodes
        val city = CrucibleCity(readInput("day17/input"))
        Assertions.assertEquals(859, city.minimumHeastLoss())
    }

    @Test
    fun part2() {
        // BFS 1728704 opened nodes
        // A*  1652188 opened nodes
        val city = CrucibleCity(readInput("day17/input"))
        Assertions.assertEquals(1027, city.minimumHeastLossUltraCrucible())
    }


}