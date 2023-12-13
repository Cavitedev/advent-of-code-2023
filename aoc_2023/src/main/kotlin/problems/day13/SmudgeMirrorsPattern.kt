package problems.day13

class SmudgeMirrorsPattern(pattern: List<List<Char>>) : MirrorsPattern(pattern) {

    constructor(smudgeMirrorsPattern: MirrorsPattern) : this(smudgeMirrorsPattern.pattern)

    override fun mirrorCheck(pattern: List<List<Char>>): Int? {
        for (i in 1..pattern.size - 1) {
            var it = 0
            var totalDif = 0
            while (i - it - 1 >= 0 && i + it < pattern.size) {
                val prevRow = pattern[i - it - 1]
                val nextRow = pattern[i + it]
                val differences = prevRow.zip(nextRow).fold(0) { acc, zipRow ->
                    acc + if (zipRow.first != zipRow.second) 1 else 0
                }
                totalDif += differences

                if (totalDif > 1) {
                    break
                }
                it++
            }
            if (totalDif == 1) {
                return i
            }
        }

        return null
    }

}

