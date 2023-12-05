package problems.day5

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Test
import problems.utils.readInput

class AlmanacTest {

    lateinit var almanac: Almanac

    @BeforeEach
    fun setupAlmanac() {
        this.almanac = Almanac.fromLines(readInput("day5/input_test"))
    }

    @Test
    fun almanacHasRightNumberOfConverters() {
        Assertions.assertEquals(7, almanac.converters.count())
    }

    @Test
    fun transformSeedsWorks() {
        Assertions.assertEquals(listOf(82L, 43L, 86L, 35L), almanac.locationsInSeeds())
    }

    @Test
    fun minLocationTest() {
        Assertions.assertEquals(35L, almanac.minLocation())
    }

}