package problems

import problems.day4.Scratchcards
import problems.utils.readInput
import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val scratchcards = Scratchcards.fromLines(readInput("day4/input"))
        scratchcards.sumWinningPoints()
    }
    println(executionTime)

}