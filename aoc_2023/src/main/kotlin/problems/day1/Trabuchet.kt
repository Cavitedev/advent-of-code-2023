package problems.day1

import problems.utils.readInput

open class Trabuchet(input: String) {

    var inputLines: List<String>

    init {
        inputLines = readInput(input)
    }

    private val optionsMapper = mapOf(
        "1" to 1,
        "2" to 2,
        "3" to 3,
        "4" to 4,
        "5" to 5,
        "6" to 6,
        "7" to 7,
        "8" to 8,
        "9" to 9
    )

    open fun getOptionsMapper(): Map<String, Int> {
        return optionsMapper
    }

    open fun getEdgeDigits(): List<List<Int>> {
        val optsMap = getOptionsMapper()
        val options = optsMap.keys
        return inputLines.map {
            val firstNumber = optsMap[it.findAnyOf(options)!!.second]!!
            val lastNumber = optsMap[it.findLastAnyOf(options)!!.second]!!
            listOf(firstNumber, lastNumber)
        }
    }

    fun sumEdgeDigits(): Int {

        val sum = getEdgeDigits().fold(0) { sum, line ->
            sum + line.first() * 10 + line.last()
        }
        return sum
    }

}