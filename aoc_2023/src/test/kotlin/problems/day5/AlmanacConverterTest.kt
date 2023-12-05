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
}