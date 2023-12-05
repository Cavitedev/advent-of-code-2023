package problems.day5

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AlmanacConverterTest {

    @Test
    fun transformNotInRangeReturnsValue() {
        val convertRange = ConvertRange(40, 60, 5)
        val convertRange2 = ConvertRange(3, 75, 12)
        val almanacConverter = AlmanacConverter(listOf(convertRange, convertRange2))
        assertEquals(39, almanacConverter.transform(39))
        assertEquals(45, almanacConverter.transform(45))
    }

    @Test
    fun transformInRangeAppliesConvert() {
        val convertRange = ConvertRange(40, 60, 5)
        val convertRange2 = ConvertRange(3, 75, 12)
        val almanacConverter = AlmanacConverter(listOf(convertRange, convertRange2))
        assertEquals(62, almanacConverter.transform(42))
        assertEquals(86, almanacConverter.transform(14))
    }


    @Test
    fun transformRangeOfValues() {
        val convertRange = ConvertRange(40, 60, 5)
        val convertRange2 = ConvertRange(3, 75, 12)
        val almanacConverter = AlmanacConverter(listOf(convertRange, convertRange2))
        assertEquals(
            listOf(
                Pair(1L, 2L),
                Pair(15L, 20L),
                Pair(75L, 86L),
                Pair(45L, 47L),
                Pair(39L, 39L),
                Pair(60L, 61L),
                Pair(63L, 64L)
            ).toSet(),
            almanacConverter.transform(listOf(Pair(1, 20), Pair(43, 47), Pair(39, 41))).toSet()
        )
    }

    @Test
    fun transformRangeOfValuesTestLight() {
        val convertRange = ConvertRange(18, 88, 7)
        val convertRange2 = ConvertRange(25, 18, 70)
        val almanacConverter = AlmanacConverter(listOf(convertRange, convertRange2))
        assertEquals(
            listOf(Pair(44L, 49L), Pair(54L, 60L), Pair(74L, 87L)).toSet(),
            almanacConverter.transform(listOf(Pair(51L, 56L), Pair(61L, 67L), Pair(81L, 94L))).toSet()
        )
    }

}