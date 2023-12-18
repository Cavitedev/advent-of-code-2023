package problems.day18

open class LavaTrench(lines: List<String>) {

    val digList: List<DigData> = lines.map { line ->
        val (dir, amount) = line.split(" ")

        DigData(
            when (dir) {
                "R" -> {
                    EastTrenchDir.getInstance()
                }

                "D" -> {
                    SouthTrenchDir.getInstance()
                }

                "L" -> {
                    WestTrenchDir.getInstance()
                }

                "U" -> {
                    NorthTrenchDir.getInstance()
                }

                else -> {
                    NorthTrenchDir.getInstance()
                }
            },
            amount.toInt(),

            )
    }


    fun filledCellsCount(): Long {

        val enhancedDigData = enhancedDigData()
        var total = enhancedDigData.fold(0L) { acc, dig ->
            acc + dig.digData.amount
        }

        for (dig in enhancedDigData) {
            if (dig.digData.direction.isHorizontal()) {
                val i = dig.i + 1

                val firstRange: IntRange = dig.toHorizontalRange()

                val adjacentPosJ = dig.digData.direction.nextPos(dig.i, dig.j).second


                val wallsToLeft = getWallsToLeft(enhancedDigData, i, adjacentPosJ)

                // Out horizontal
                if (wallsToLeft.size % 2 == 0) {
                    continue
                }

                total += totalRange(firstRange, i, enhancedDigData)

            }


        }

        return total
    }

    fun getWallsToLeft(
        enhancedDigData: List<EnhancedDigData>,
        i: Int,
        j: Int
    ): List<EnhancedDigData> {
        val wallsLeft = enhancedDigData.filter { it.isInRow(i) && it.j < j }
//        return wallsLeft
        return wallsLeft.filter {
            val endPos = it.endPos()
            !wallsLeft.any { it.i == endPos.first && it.j == endPos.second }
        }
    }

    private fun totalRange(
        checkRange: IntRange,
        i: Int,
        enhancedDigData: List<EnhancedDigData>,
    ): Long {
        var total = 0L
        val intersectDirs = enhancedDigData.filter { it.isInRow(i) }
        val fallRanges: MutableList<IntRange> = mutableListOf(checkRange)


        val nextI =
            enhancedDigData.filter { it.digData.direction.isHorizontal() && it.i > i }.minOfOrNull { it.i } ?: return 0L

        for (intersectDir in intersectDirs) {
            val intersectRange = intersectDir.toHorizontalRange()
            val overlappedRanges =
                fallRanges.filter {
                    (intersectRange.contains(it.first) || intersectRange.contains(it.last)) ||
                            (intersectRange.first > it.first && intersectRange.last < it.last)
                }

            for (overlapRange in overlappedRanges) {
                fallRanges.remove(overlapRange)
                // Left
                if (intersectRange.first > overlapRange.first) {
                    val nextRange = overlapRange.first..intersectRange.first - 1
                    fallRanges.add(nextRange)
                }

                // Right
                if (intersectRange.last < overlapRange.last) {
                    val nextRange = intersectRange.last + 1..overlapRange.last
                    fallRanges.add(nextRange)
                }
            }
        }

        total += fallRanges.sumOf {
            totalRange(it, nextI, enhancedDigData)
        }

        val spacesInRow = fallRanges.fold(0L) { acc, range ->
            acc + range.last - range.first + 1
        }

        total += spacesInRow * (nextI - i).toLong()

        return total
    }

    fun printInput() {
        val enhancedData = enhancedDigData()
        val minI = enhancedData.minOf { it.i }
        val minJ = enhancedData.minOf { it.j }
        val maxI = enhancedData.maxOf { it.i }
        val maxJ = enhancedData.maxOf { it.j }

        for (i in minI..maxI) {
            val chars = mutableListOf<Char>()
            for (j in minJ..maxJ) {
                val exists = enhancedData.any { it.isInCell(i, j) }
                val addChar = if (exists) '#' else '.'
                chars.add(addChar)
            }
            println(chars.joinToString(""))
        }
    }


    fun enhancedDigData(): List<EnhancedDigData> {
        val returnData = mutableListOf<EnhancedDigData>()
        var i = 0
        var j = 0

        for (dig in digList) {
            returnData.add(EnhancedDigData(i, j, dig))
            val (i2, j2) = dig.direction.nextPos(i, j)
            var di = i2 - i
            var dj = j2 - j
            di *= dig.amount
            dj *= dig.amount
            i += di
            j += dj
        }
        return returnData
    }


}