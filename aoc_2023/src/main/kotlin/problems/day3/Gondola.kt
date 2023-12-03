package problems.day3

class Gondola(val symbolNumbers: List<SymbolNumbers>) {


    companion object {
        val symbolRegex = Regex("""[^\d.]""")

        fun fromLines(lines: List<String>): Gondola {
            val symbolNumbers = mutableListOf<SymbolNumbers>()
            for (i in lines.indices) {
                val line = lines[i]
                for (j in line.indices) {
                    val char = line[j]

                    if (symbolRegex.matches(char.toString())) {
                        val numbersArooundCoordinate = numbersAroundCoordinate(lines, i, j)
                        symbolNumbers.add(SymbolNumbers(char, numbersArooundCoordinate))
                    }


                }
            }
            return Gondola(symbolNumbers)
        }

        private fun numbersAroundCoordinate(lines: List<String>, i: Int, j: Int): List<Int> {
            val listNumbers: MutableList<Int> = mutableListOf()
            var jContinue: Int

            for (i2 in i - 1..<i + 2) {
                jContinue = -1
                for (j2 in j - 1..<j + 2) {
                    if (i2 == i && j2 == j) continue
                    if (jContinue >= j2) continue
                    val line = lines[i2]
                    val char = line[j2]
                    if (char.isDigit()) {


                        val digitsBefore: MutableList<Char> = mutableListOf()
                        for (x1 in j2 - 1 downTo 0) {
                            if (line[x1].isDigit()) {
                                digitsBefore.add(0, line[x1])
                            } else {
                                break
                            }
                        }

                        val digitsAfter: MutableList<Char> = mutableListOf()
                        for (x2 in j2 + 1 until line.length) {
                            if (line[x2].isDigit()) {
                                digitsAfter.add(line[x2])
                            } else {
                                break
                            }
                        }

                        val numString = digitsBefore.joinToString("") + char + digitsAfter.joinToString("")
                        listNumbers.add(numString.toInt())
                        jContinue = j2 + digitsAfter.count()
                    }
                }
            }
            return listNumbers
        }
    }

    fun sumValues(): Int {
        return this.symbolNumbers.fold(0) { acc, symbolNumbers ->
            acc + symbolNumbers.numbers.sum()
        }
    }
}