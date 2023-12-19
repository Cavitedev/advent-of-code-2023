package problems.day19.part2

class PartWorkflow2(val workflowConditions: List<WorkflowStep2>) {

    fun resultFromPart(part: PartRange): List<PartRangeNext> {
        var falsePart = part
        val returnList = mutableListOf<PartRangeNext>()
        for (workflow in workflowConditions) {
            val results = workflow.resultFromPart(falsePart)
            returnList.add(results.first())
            if (results.size == 2) {
                falsePart = results[1].partRange
            }
        }
        return returnList
    }

}