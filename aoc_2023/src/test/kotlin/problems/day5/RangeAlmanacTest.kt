package problems.day5

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import problems.utils.readInput

class RangeAlmanacTest {

    lateinit var almanac: RangeAlmanac

    @BeforeEach
    fun setupAlmanac() {
        this.almanac = RangeAlmanac.fromLines(readInput("day5/input_test"))

    }

    @Test
    fun almanacHasRightNumberOfConverters() {
        Assertions.assertEquals(7, almanac.converters.count())
    }

    @Test
    fun almanacHasRightSeeds() {
        Assertions.assertEquals(listOf(Pair(79L, 92L), Pair(55L, 67L)), almanac.seedRanges)
    }

    @Test
    fun transformSeedsWorks() {
        Assertions.assertEquals(listOf(Pair(1L, 2L)), almanac.rangeLocationsInSeeds())
    }

    @Test
    fun minLocationTest() {
        Assertions.assertEquals(46L, almanac.minLocation())
    }

}