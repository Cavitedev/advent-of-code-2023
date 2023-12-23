package problems.day23

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import problems.utils.readInput

class HikingMapTest {

    lateinit var hikingMap: HikingMap

    @BeforeEach
    fun setUp() {
        hikingMap = HikingMap(readInput("day23/it1"))
    }

    @Test
    fun getMap() {
        assertEquals(2, hikingMap.map[4].filter { it.canWalk && it.dir != null }.size)
        assertEquals(4, hikingMap.map[4].filter { it.canWalk && it.dir == null }.size)
    }

    @Test
    fun longestPath() {
        assertEquals(94, hikingMap.longestPath())
    }


    @Test
    fun longestPathNoSlopes() {
        hikingMap.removeSlopes()
        assertEquals(154, hikingMap.longestPath())
    }
}