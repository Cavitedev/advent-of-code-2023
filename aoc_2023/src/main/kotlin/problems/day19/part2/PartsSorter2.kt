package problems.day19.part2

class PartsSorter2(lines: List<String>) {

    val workflows: Map<String, PartWorkflow2>


    init {
        val workflowLines = lines.takeWhile { it.isNotEmpty() }


        val workflowRegex = Regex("""(\w+)\{(.*)\}""")
        val innerWorkflowRegex = Regex("""(\w+)([<>])(\d+):(\w+)""")

        this.workflows = workflowLines.map { line ->
            val matches = workflowRegex.findAll(line).first().groupValues
            val key = matches[1]
            val content = matches[2]

            val workflowStepsStr = content.split(",")
            val workflowSteps = workflowStepsStr.map {
                val condMatches = innerWorkflowRegex.findAll(it).firstOrNull()
                if (condMatches == null) {
                    WorkflowStep2(it)
                } else {
                    val groupValues = condMatches.groupValues
                    WorkflowStepCondition2(
                        groupValues[1].toCharArray().first(),
                        groupValues[2].toCharArray().first(),
                        groupValues[3].toInt(),
                        groupValues[4]
                    )
                }

            }
            return@map key to PartWorkflow2(workflowSteps)
        }.toMap()


    }

    fun totalRatingNumber(): Long {
        val acceptedParts = acceptedParts()
        return acceptedParts.fold(0L) { acc, part ->
            acc + part.totalComb()
        }
    }

    fun acceptedParts(): List<PartRange> {

        val initialPart =
            PartRangeNext("in", PartRange(listOf(1..4000), listOf(1..4000), listOf(1..4000), listOf(1..4000)))

        val pendingParts = mutableListOf(initialPart)
        val acceptedParts = mutableListOf<PartRange>()

        while (pendingParts.isNotEmpty()) {
            val nextPart = pendingParts.removeAt(0)
            val workflowRes = workflows[nextPart.next]!!.resultFromPart(nextPart.partRange)
            acceptedParts.addAll(workflowRes.filter { it.next == "A" }.map { it.partRange })

            val nextParts = workflowRes.filter { it.next != "A" && it.next != "R" }
            pendingParts.addAll(nextParts)
        }
        return acceptedParts

    }

}