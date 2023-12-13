package problems.day13

class MirrorsValley(val input: List<String>) {


    val patterns: List<MirrorsPattern> = input.joinToString(";").split(";;").map { lineArray ->
        MirrorsPattern(lineArray.split(";").map { it.toList() })
    }

    fun sumMirrors(): Long {
        return patterns.fold(0L) { acc, pattern ->
            val addValue = pattern.mirrorCol() ?: (pattern.mirrorRow()!! * 100)
            acc + addValue.toLong()
        }
    }

}