package problems.day19

class PartWorkflow(val workflowConditions: List<WorkflowStep>) {

    fun resultFromPart(part: Part): String {
        return workflowConditions.map { it.resultFromPart(part) }.first { it != null }!!
    }

}