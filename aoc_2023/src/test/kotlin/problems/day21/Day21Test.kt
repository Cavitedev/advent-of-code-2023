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
        garden.repeat(7)
        garden.search()

        println(garden.countBySections(1500L).map { line ->
            line.map { String.format("%${4}d", it) }
        }.joinToString("\n"))
// max n == 1
        // n = 6 1461860
        // n = 7 1638452

        println(garden.countPlotsAtStep(1500L))
        Assertions.assertEquals(1930165, garden.countPlotsOptimizedAtStep(1500L))

//        Assertions.assertEquals(1930165, garden.countPlotsAtStep(1500L))
// 603247660959412 Too High
// 602247660959412 Too Low
// 602247660959412 n = 16

        // n = 1500, steps = 1500

//        println(garden.countPlotsOptimizedAtStep(26501365L))
//        Assertions.assertEquals(0, garden.countPlotsOptimizedAtStep(26501365L))

//        for (n in 0..500L) {
//            val total = garden.countPlotsAtStep(n)
//            println("n=$n, total= $total")
//            println(garden.countBySections(n).map { it.map { num -> String.format("%${4}d", num) } }.joinToString("\n"))
//        }
//        val n = 1000001L
//        val total = garden.countPlotsAtStep(n)
//        println(total)

    }

}