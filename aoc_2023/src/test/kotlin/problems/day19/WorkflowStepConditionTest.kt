package problems.day19

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WorkflowStepConditionTest {

    @Test
    fun resultFromStep() {
        val part = Part(1, 3, 6, 8)
        val cond = WorkflowStepCondition('m', '<', 4, "S")
        assertEquals("S", cond.resultFromPart(part))

        val cond2 = WorkflowStepCondition('m', '>', 4, "S")
        assertEquals(null, cond2.resultFromPart(part))
    }
}