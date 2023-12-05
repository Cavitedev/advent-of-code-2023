package problems.day5

data class ConvertRange(val startFrom: Long, val convertFrom: Long, val length: Long) {

    fun convert(input: Long): Long? {

        val diff = input - startFrom

        if (diff < 0 || diff >= length) {
            return null
        }

        return convertFrom + diff
    }

}