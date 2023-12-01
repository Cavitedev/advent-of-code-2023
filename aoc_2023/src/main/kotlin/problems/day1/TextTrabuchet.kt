package problems.day1

class TextTrabuchet(input: String) : Trabuchet(input) {


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


    init {
        inputLines = inputLines.map { line ->
            var lineCopy = ""
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
            lineCopy
        }


    }

}