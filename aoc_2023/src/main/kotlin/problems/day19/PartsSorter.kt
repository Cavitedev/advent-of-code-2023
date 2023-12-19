package problems.day19

class PartsSorter(lines: List<String>) {

    val workflows: Map<String, PartWorkflow>
    val parts: List<Part>

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
                    WorkflowStep(it)
                } else {
                    val groupValues = condMatches.groupValues
                    WorkflowStepCondition(
                        groupValues[1].toCharArray().first(),
                        groupValues[2].toCharArray().first(),
                        groupValues[3].toInt(),
                        groupValues[4]
                    )
                }

            }
            return@map key to PartWorkflow(workflowSteps)
        }.toMap()

        val partsLines = lines.takeLastWhile { it.isNotEmpty() }


        val partsRegex = Regex("""=(\d+)""")

        this.parts = partsLines.map { line ->
            val values = line.split(",").map { partsRegex.find(it)!!.groupValues[1].toInt() }
            return@map Part(values[0], values[1], values[2], values[3])
        }
    }

    fun totalRatingNumber(): Long {
        val acceptedParts = acceptedParts()
        return acceptedParts.fold(0L) { acc, part ->
            acc + part.totalAmount()
        }
    }

    fun acceptedParts(): List<Part> {


        return this.parts.filter { part ->
            var key = "in"
            while (key != "A" && key != "R") {
                key = workflows[key]!!.resultFromPart(part)
            }
            key == "A"
        }

    }

}