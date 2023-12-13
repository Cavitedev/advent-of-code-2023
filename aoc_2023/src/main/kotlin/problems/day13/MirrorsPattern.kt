package problems.day13

import Utils.Companion.transpose

open class MirrorsPattern(val pattern: List<List<Char>>) {


    fun mirrorRow(): Int? {
        return mirrorCheck(pattern)
    }

    fun mirrorCol(): Int? {
        return mirrorCheck(pattern.transpose())
    }

    open fun mirrorCheck(pattern: List<List<Char>>): Int? {
        for (i in 1..pattern.size - 1) {
            var it = 0
            var matches = true

            while (i - it - 1 >= 0 && i + it < pattern.size) {
                val prevRow = pattern[i - it - 1]
                val nextRow = pattern[i + it]
                it++
                if (prevRow != nextRow) {
                    matches = false
                    break
                }
            }
            if (matches) {
                return i
            }
        }

        return null
    }

}