package problems.day11

import kotlin.math.abs

class Galaxies(lines: List<String>) {

    val galaxiesList: List<Galaxy>

    init {
        val galaxiesMut = mutableListOf<Galaxy>()

        for (i in lines.indices) {
            val line = lines[i]
            for (j in line.indices) {
                val char = line[j]
                if (char == '#') {
                    galaxiesMut.add(Galaxy(i, j))
                }
            }
        }
        this.galaxiesList = galaxiesMut
    }

    fun expand() {
        val iSorted = this.galaxiesList.sortedBy { it.i }

        var lastI = iSorted.first().i
        var expandAmount = 0
        for (galaxy in iSorted.drop(1)) {
            val dif = galaxy.i - lastI
            if (dif > 1)
                expandAmount += dif - 1
            lastI = galaxy.i
            galaxy.i += expandAmount
        }

        val jSorted = this.galaxiesList.sortedBy { it.j }

        var lastJ = jSorted.first().j
        expandAmount = 0
        for (galaxy in jSorted.drop(1)) {
            val dif = galaxy.j - lastJ
            if (dif > 1)
                expandAmount += dif - 1
            lastJ = galaxy.j
            galaxy.j += expandAmount
        }
    }

    fun sumDistances(): Long {
        return this.galaxiesList.foldIndexed(0) { index, acc, galaxy ->
            acc + this.galaxiesList.drop(index + 1).fold(0) { acc2, galaxy2 ->
                acc2 + abs(galaxy.i - galaxy2.i) + abs(galaxy.j - galaxy2.j)
            }
        }
    }

}