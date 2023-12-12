package problems.day12

import Utils

class HotSpringsGroup(val lines: List<String>) {

    val springLines: List<HotSpringLine>

    init {
        this.springLines = this.lines.map { line ->
            val (springs, records) = line.split(" ")
            val numbers = Utils.numbersInLineString(records).map { it.toInt() }
            HotSpringLine(springs, numbers)
        }
    }

    fun sumArrangementsCount(): Long {
        return this.springLines.foldIndexed(0L) { i, acc, spring ->
            acc + spring.arrangementsCount()
        }
    }

    fun foldLines() {
        this.springLines.forEach { it.fold() }
    }
}