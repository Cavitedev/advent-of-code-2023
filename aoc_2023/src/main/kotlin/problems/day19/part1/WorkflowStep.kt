package problems.day19.part1

open class WorkflowStep(val result: String) {

    open fun resultFromPart(part: Part): String? {
        return result
    }

}

class WorkflowStepCondition(val checkVal: Char, val comparator: Char, val value: Int, result: String) :
    WorkflowStep(result) {

    override fun resultFromPart(part: Part): String? {
        val isTrue = isConditionTrue(part)
        if (isTrue) {
            return super.resultFromPart(part)
        }
        return null
    }

    private fun isConditionTrue(part: Part): Boolean {
        val partValue = part.valChar(checkVal)
        if (comparator == '<')
            return partValue < value
        return partValue > value
    }

}