package problems.day5

open class Almanac(val seeds: List<Long>, val converters: List<AlmanacConverter>) {

    companion object {

        val numbersRegex = Regex("""\d+""")

        fun fromLines(lines: List<String>): Almanac {
            val seeds = numbersRegex.findAll(lines[0]).map { it.value.toLong() }.toList()

            val converters: MutableList<AlmanacConverter> = mutableListOf()

            var ranges: MutableList<ConvertRange> = mutableListOf()
            for (line in lines.drop(2)) {
                if (line.contains("map")) {
                    if (ranges.isNotEmpty()) {
                        converters.add(AlmanacConverter(ranges))
                    }
                    ranges = mutableListOf()
                    continue
                }
                val range = numbersRegex.findAll(line).map { it.value.toLong() }.toList()
                if (range.count() == 3) {
                    ranges.add(ConvertRange(range[1], range[0], range[2]))
                }

            }

            converters.add(AlmanacConverter(ranges))
            return Almanac(seeds, converters)
        }

    }

    fun locationsInSeeds(): List<Long> {

        return this.seeds.map { seed ->
            this.converters.fold(seed) { acc, converter ->
                converter.transform(acc)
            }
        }
    }

    open fun minLocation(): Long {
        return this.locationsInSeeds().min()
    }

}