package problems.day20

data class RepeatAmounts(val repeatAmount: MutableList<RepeatAmount>) {

    fun add(value: Boolean) {
        val lastList = repeatAmount.lastOrNull()
        if (lastList?.value == value) {
            lastList.amount++
            return
        }
        repeatAmount.add(RepeatAmount(value, 1))

    }

    fun toPattern(): PulsePattern {

        val pattern = mutableListOf<RepeatAmount>()
        var n = 1
        do {
            pattern.add(this.repeatAmount[n])
            pattern.add(this.repeatAmount[n + 1])
            n += 2
        } while (!checkPattern(n, pattern))

        var start = this.repeatAmount.first().amount.toLong()
        val size = pattern.fold(0) { acc, rep ->
            acc + rep.amount
        }
        val longRanges = mutableListOf<LongRange>()
        for (patternEl in pattern) {
            if (patternEl.value) {
                val end = patternEl.amount + start
                if (end > size) {
                    if (size > start) {
                        longRanges.add(start..<size)
                    }
                    longRanges.add(0..<end - size)
                } else {
                    longRanges.add(start..<end)
                }
            }

            start += patternEl.amount
        }


        return PulsePattern(longRanges, size.toLong())
    }

    fun checkPattern(n: Int, pattern: List<RepeatAmount>): Boolean {
        val nextReps = this.repeatAmount.drop(n)
        val rep = pattern.size
        for (i in 0..<rep) {
            if (nextReps[i] != pattern[i % rep]) {
                return false
            }
        }

        return true
    }

    override fun toString(): String {
        return "$repeatAmount"
    }


}

class RepeatAmount(val value: Boolean, var amount: Int) {
    override fun toString(): String {
        return "${valueStr()}$amount"
    }

    private fun valueStr(): String {
        return if (value) "T" else "F"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RepeatAmount) return false

        if (value != other.value) return false
        if (amount != other.amount) return false

        return true
    }

    override fun hashCode(): Int {
        var result = value.hashCode()
        result = 31 * result + amount
        return result
    }


}