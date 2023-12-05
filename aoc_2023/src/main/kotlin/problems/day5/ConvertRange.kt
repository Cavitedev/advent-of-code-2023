package problems.day5

data class ConvertRange(val startFrom: Long, val convertFrom: Long, val length: Long) {

    fun convert(input: Long): Long? {

        val diff = input - startFrom

        if (diff < 0 || diff >= length) {
            return null
        }

        return convertFrom + diff
    }

    fun convert(input: List<Pair<Long, Long>>): List<Pair<Long, Long>> {

        val diffConvert = convertFrom - startFrom

        val returnList: MutableList<Pair<Long, Long>> = mutableListOf()

        for (range in input) {
            if (range.first >= this.startFrom + length || range.second < this.startFrom) {
                returnList.add(range)
                continue
            }


            var rangeFirst = range.first + diffConvert
            var rangeSecond = range.second + diffConvert

            if (range.first < this.startFrom) {
                returnList.add(Pair(range.first, this.startFrom - 1))
                rangeFirst = this.startFrom + diffConvert
            }

            if (range.second >= this.startFrom + length) {
                returnList.add(Pair(this.startFrom + length, range.second))
                rangeSecond = this.convertFrom + length - 1
            }

            returnList.add(Pair(rangeFirst, rangeSecond))


        }

        return returnList
    }

}