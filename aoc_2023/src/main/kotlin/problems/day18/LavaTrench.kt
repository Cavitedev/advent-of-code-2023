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
                var i = dig.i + 1

                val firstRange: IntRange = dig.toHorizontalRange()

                val adjacentPosJ = dig.digData.direction.nextPos(dig.i, dig.j).second


                val wallsToLeft = enhancedDigData.filter { it.isInRow(i) && it.j < adjacentPosJ }

                // Out horizontal
                if (wallsToLeft.size % 2 == 0) {
                    continue
                }

                total += totalRange(firstRange, i, enhancedDigData)

            }


        }

        return total
    }

    private fun totalRange(
        checkRange: IntRange,
        i2: Int,
        enhancedDigData: List<EnhancedDigData>,
    ): Long {
        var i = i2
        var total = 0L
        val fallRanges: MutableList<IntRange> = mutableListOf(checkRange)
        while (fallRanges.isNotEmpty()) {


            val intersectDirs = enhancedDigData.filter { it.isInRow(i) }


            for (intersectDir in intersectDirs) {
                val intersectRange = intersectDir.toHorizontalRange()
                val overlappedRanges =
                    fallRanges.filter {

                        intersectRange.contains(it.first) || intersectRange.contains(it.last)

                    }
                for (overlapRange in overlappedRanges) {
                    fallRanges.remove(overlapRange)

                    // Left
                    if (intersectRange.first > overlapRange.first) {
                        fallRanges.add(overlapRange.first..intersectRange.first - 1)
                    }

                    // Right
                    if (intersectRange.last < overlapRange.last) {
                        fallRanges.add(intersectRange.last + 1..overlapRange.last)
                    }
                }

            }
            val spacesInRow = fallRanges.fold(0) { acc, range ->
                acc + range.last - range.first + 1
            }


            if (intersectDirs.size == 2 && intersectDirs.all { it.digData.direction.isVertical() }) {
                val nextI =
                    enhancedDigData.filter { it.digData.direction.isHorizontal() && it.i > i }.minOf { it.i }
                total += spacesInRow * (nextI - i)
                i = nextI

            }


            total += spacesInRow
            i++


        }
        return total
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