package problems.day3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import problems.utils.readInput

class GondolaTest {

    lateinit var gondola: Gondola

    @BeforeEach
    fun setup() {
        this.gondola = Gondola.fromLines(readInput("day3/input_test"))
    }

    @Test
    fun fromLinesIsRight() {
        val expected = listOf(
            SymbolNumbers('*', listOf(467, 35)),
            SymbolNumbers('#', listOf(633)),
            SymbolNumbers('*', listOf(617)),
            SymbolNumbers('+', listOf(592)),
            SymbolNumbers('$', listOf(664)),
            SymbolNumbers('*', listOf(755, 598)),
        )
        assertEquals(expected, this.gondola.symbolNumbers)
    }

    @Test
    fun sumValues() {
        assertEquals(4361, gondola.sumValues())
    }

    @Test
    fun gearRatio() {
        assertEquals(467835, gondola.gearRatio())
    }

}