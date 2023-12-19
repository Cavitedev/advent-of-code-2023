package problems.day19.part2

data class PartRange(val x: List<IntRange>, val m: List<IntRange>, val a: List<IntRange>, val s: List<IntRange>) {

    fun valFromChar(char: Char): List<IntRange> {
        return when (char) {
            'x' -> {
                x
            }

            'm' -> {
                m
            }

            'a' -> {
                a
            }

            's' -> {
                s
            }

            else -> {
                listOf()
            }
        }
    }

    fun copyWith(char: Char, value: List<IntRange>): PartRange {
        return when (char) {
            'x' -> {
                PartRange(value, m, a, s)
            }

            'm' -> {
                PartRange(x, value, a, s)
            }

            'a' -> {
                PartRange(x, m, value, s)
            }

            's' -> {
                PartRange(x, m, a, value)
            }

            else -> {
                throw Exception("Invalid char")
            }
        }
    }

    fun totalComb(): Long {

        val els = listOf(x, m, a, s)


        return els.fold(1L) { acc, el ->
            acc * el.fold(0L) { acc2, range ->
                acc2 + range.last - range.first + 1
            }
        }
    }


}

