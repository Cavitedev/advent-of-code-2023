package problems.day19.part2

open class WorkflowStep2(val result: String) {

    open fun resultFromPart(part: PartRange): List<PartRangeNext> {
        return listOf(PartRangeNext(result, part))
    }

}

class WorkflowStepCondition2(val checkVal: Char, val comparator: Char, val value: Int, result: String) :
    WorkflowStep2(result) {

    override fun resultFromPart(part: PartRange): List<PartRangeNext> {
        val ranges = part.valFromChar(checkVal)

        val lessThanRanges = mutableListOf<IntRange>()
        val greaterThanRanges = mutableListOf<IntRange>()

        for (range in ranges) {

            if (range.last < value) {
                lessThanRanges.add(range)
            } else if (range.first > value) {
                greaterThanRanges.add(range)
            } else {
                lessThanRanges.add(range.first..value - (if (comparator == '<') 1 else 0))
                greaterThanRanges.add(value + (if (comparator == '>') 1 else 0)..range.last)
            }
        }

        val trueRange = if (comparator == '<') lessThanRanges else greaterThanRanges
        val truePartRangeNext = PartRangeNext(result, part.copyWith(checkVal, trueRange))

        val falseRange = if (comparator == '>') lessThanRanges else greaterThanRanges
        val falsePartRangeNext = PartRangeNext(null, part.copyWith(checkVal, falseRange))

        return listOf(truePartRangeNext, falsePartRangeNext)
    }


}