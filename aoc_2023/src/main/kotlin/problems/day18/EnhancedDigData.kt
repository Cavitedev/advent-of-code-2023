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