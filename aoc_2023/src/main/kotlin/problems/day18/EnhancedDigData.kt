package problems.day18

data class EnhancedDigData(val i: Int, val j: Int, val digData: DigData) {

    fun isInRow(i: Int): Boolean {
        if (digData.direction.isHorizontal()) {
            return i == this.i
        }
        // Vertical
        lateinit var range: IntRange
        if (digData.direction == SouthTrenchDir.getInstance()) {
            range = this.i..this.i + digData.amount - 1
        } else {
            range = this.i - digData.amount + 1..this.i
        }
        return range.contains(i)
    }

    fun isInCol(j: Int): Boolean {
        val range = toHorizontalRange()
        return range.contains(j)
//        if (digData.direction.isVertical()) {
//            return j == this.j
//        }
//        // Vertical
//        lateinit var range: IntRange
//        if (digData.direction == EastTrenchDir.getInstance()) {
//            range = this.j..this.j + digData.amount - 1
//        } else {
//            range = this.j - digData.amount + 1..this.j
//        }
//        return range.contains(j)
    }

    fun isInCell(i: Int, j: Int): Boolean {
        return isInRow(i) && isInCol(j)
    }

    fun endPos(): Pair<Int, Int> {
        val (i2, j2) = digData.direction.nextPos(i, j)
        var di = i2 - i
        var dj = j2 - j
        di *= digData.amount
        dj *= digData.amount
        return Pair(i + di, j + dj)
    }

    /**
     * Assumes the dig is on that row
     */
    fun toHorizontalRange(): IntRange {
        if (digData.direction.isVertical()) {
            return j..j
        }

        if (digData.direction == EastTrenchDir.getInstance()) {
            return j..j + digData.amount
        } else {
            return j - digData.amount..j
        }

    }


}