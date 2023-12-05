package problems.day5

class RangeAlmanac(seeds: List<Long>, converters: List<AlmanacConverter>) : Almanac(seeds, converters) {

    val seedRanges: List<Pair<Long, Long>> = super.seeds.chunked(2).map { Pair(it.get(0), it.get(0) + it.get(1) - 1) }

    companion object {
        fun fromLines(lines: List<String>): RangeAlmanac {
            val almanac = Almanac.fromLines(lines)
            return RangeAlmanac(almanac.seeds, almanac.converters)
        }
    }

    fun rangeLocationsInSeeds(): List<Pair<Long, Long>> {

        return this.converters.fold(seedRanges) { acc, converter ->
            converter.transform(acc)
        }
    }

    override fun minLocation(): Long {
        return this.rangeLocationsInSeeds().map { it.first }.min()
    }

}