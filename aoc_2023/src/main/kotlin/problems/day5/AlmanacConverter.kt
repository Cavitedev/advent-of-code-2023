package problems.day5

data class AlmanacConverter(val ranges: List<ConvertRange>) {

    fun transform(input: Long): Long {
        return (ranges.map { it.convert(input) }.find { it != null } ?: input)
    }

    fun transform(input: List<Pair<Long, Long>>): List<Pair<Long, Long>> {
        return ranges.fold(input) { acc, range ->
            range.convert(acc)
        }
    }
}