package problems.day5

data class AlmanacConverter(val ranges: List<ConvertRange>) {

    fun transform(input: Long): Long {
        return (ranges.map { it.convert(input) }.find { it != null } ?: input)
    }

    fun transform(input: List<Pair<Long, Long>>): List<Pair<Long, Long>> {
        val convertedValues: MutableList<Pair<Long, Long>> = mutableListOf()

        val returnedValues = ranges.fold(input) { acc, range ->
            val converted = range.convert(acc)
            if (converted.isNotEmpty()) {
                convertedValues.addAll(converted[0])
            }
            converted[1]

        }
        convertedValues.addAll(returnedValues)

        return convertedValues
    }
}