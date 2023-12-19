package problems.day19.part2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WorkflowStepCondition2Test {

    @Test
    fun resultFromPart() {

        val partRange = PartRange(listOf(1..1000, 2500..4000), listOf(1..4000), listOf(1..1), listOf(1..3))
        val cond = WorkflowStepCondition2('x', '<', 500, "S")
        val res = cond.resultFromPart(partRange)
        val truePart = PartRangeNext("S", PartRange(listOf(1..499), listOf(1..4000), listOf(1..1), listOf(1..3)))
        val falsePart =
            PartRangeNext(null, PartRange(listOf(500..1000, 2500..4000), listOf(1..4000), listOf(1..1), listOf(1..3)))

        assertEquals(truePart, res[0])
        assertEquals(falsePart, res[1])
    }
}