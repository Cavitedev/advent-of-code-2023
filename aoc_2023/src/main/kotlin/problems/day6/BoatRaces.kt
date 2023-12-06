package problems.day6

class BoatRaces(val races: List<BoatRace>) {


    companion object {

        val numbersRegex = Regex("""\d+""")

        fun fromLines(lines: List<String>): BoatRaces {

            val times = numbersRegex.findAll(lines[0])
            val distances = numbersRegex.findAll(lines[1])

            val races = times.zip(distances).map {
                BoatRace(it.first.value.toLong(), it.second.value.toLong())
            }.toList()

            return BoatRaces(races)
        }


        fun fromRightKerningLines(lines: List<String>): BoatRaces {
            val time = numbersRegex.findAll(lines[0]).map { it.value }.joinToString("")
            val distance = numbersRegex.findAll(lines[1]).map { it.value }.joinToString("")
            return BoatRaces(listOf(BoatRace(time.toLong(), distance.toLong())))
        }

    }

    fun waysOfBeatingRecordsProduct(): Long {
        return races.fold(1) { acc, race ->
            acc * race.waysOfBeatingRecord()
        }
    }

}