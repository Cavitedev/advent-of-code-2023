package problems.day1

import problems.utils.readInput

open class Trabuchet(input: String) {

    var inputLines: List<String>

    init {
        inputLines = readInput(input)
    }


    fun getNumberLines(): List<List<Int>> {
        val numberLines = mutableListOf<List<Int>>()

        for (line in inputLines) {
            val charArray = line.toCharArray()

            val numbersList: List<Int> = charArray.filter { it.isDigit() }.map { it.digitToInt() }
            numberLines.add(numbersList)
        }
        return numberLines
    }

    fun sumEdgeDigits(): Int {

        val sum = getNumberLines().fold(0) { sum, line ->
            sum + line.first() * 10 + line.last()
        }
        return sum
    }

}