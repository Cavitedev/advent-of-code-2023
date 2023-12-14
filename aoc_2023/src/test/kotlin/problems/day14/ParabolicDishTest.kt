package problems.day14

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import problems.utils.readInput

class ParabolicDishTest {

    lateinit var dish: ParabolicDish

    @BeforeEach
    fun setUp() {
        dish = ParabolicDish(readInput("day14/it1"))
    }

    @Test
    fun tiltOnce() {
        dish.tiltOnce(NorthTiltDirection.getInstance())
        assertEquals("OO..#....#", dish.lines[1])
    }

    @Test
    fun sumLoad() {
        dish.tiltOnce(NorthTiltDirection.getInstance())
        assertEquals(136L, dish.sumLoad())
    }
}