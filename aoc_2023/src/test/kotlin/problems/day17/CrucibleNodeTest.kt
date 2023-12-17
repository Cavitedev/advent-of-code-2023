package problems.day17

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CrucibleNodeTest {

    @Test
    fun repeatedDirs() {
        val node1 = CrucibleNode(0, 1, 0, 0, EastCrucibleDir.getInstance(), null)
        assertEquals(1, node1.repeatedDirs())
        val node2 = CrucibleNode(0, 2, 3, 0, EastCrucibleDir.getInstance(), node1)
        assertEquals(2, node2.repeatedDirs())
        val node3 = CrucibleNode(1, 2, 5, 0, SouthCrucibleDir.getInstance(), node2)
        assertEquals(1, node3.repeatedDirs())
    }
}