package problems.day5

data class AlmanacConverter(val ranges: List<ConvertRange>) {

    fun transform(input: Long): Long {
        return (ranges.map { it.convert(input) }.find { it != null } ?: input)
    }


}