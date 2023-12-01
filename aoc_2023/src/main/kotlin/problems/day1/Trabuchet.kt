package problems.day1

import problems.utils.readInput

class Trabuchet(input: String) {

    val inputLines: List<String>

    init {
        inputLines = readInput(input)
    }

    private val numberMap = mapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5,
        "six" to 6,
        "seven" to 7,
        "eight" to 8,
        "nine" to 9,
    )


    private val regex = Regex("one|two|three|four|five|six|seven|eight|nine|1|2|3|4|5|6|7|8|9")

    fun getNumberLines(useTextNumbers: Boolean = false): List<List<Int>> {
        val numberLines = mutableListOf<List<Int>>()

        for (line in inputLines) {
            var lineCopy = line
            if (useTextNumbers) {
                lineCopy = ""
                var matchIndex = 0
                var match = regex.find(line, matchIndex)
                while (match != null) {
                    if (numberMap.containsKey(match.value)) {
                        lineCopy += numberMap.get(match.value)
                    } else {
                        lineCopy += match.value
                    }
                    matchIndex = match.range.first + 1
                    match = regex.find(line, matchIndex)
                }


//                val matches = regex.findAll(line)
//                for (match in matches) {
//                    if (numberMap.containsKey(match.value)) {
//                        lineCopy += numberMap.get(match.value);
//                    } else {
//                        lineCopy += match.value
//                    }
//
//                }
            }
            val charArray = lineCopy.toCharArray()

            val numbersList: List<Int> = charArray.filter { it.isDigit() }.map { it.digitToInt() }
            numberLines.add(numbersList)
        }
        return numberLines
    }

    fun sumEdgeDigits(useTextNumbers: Boolean = false): Int {

        val sum = getNumberLines(useTextNumbers).fold(0) { sum, line ->
            sum + line.first() * 10 + line.last()
        }
        return sum
    }

}