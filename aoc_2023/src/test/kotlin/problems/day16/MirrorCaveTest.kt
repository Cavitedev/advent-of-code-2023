package problems.day16

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import problems.day16.cells.HorizontalSplitterMirrorCell
import problems.utils.readInput

class MirrorCaveTest {

    lateinit var cave: MirrorCave

    @BeforeEach
    fun setUp() {
        cave = MirrorCave(readInput("day16/it1"))
    }

    @Test
    fun getGrid() {
        assertEquals(10, cave.grid.size)
        assertEquals(HorizontalSplitterMirrorCell.getInstance(), cave.grid[1][2])
    }

    @Test
    fun energizedBeans() {
        assertEquals(46, cave.energizedBeansTopLeft())
    }
}