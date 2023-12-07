package problems.day7

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import problems.utils.readInput

class CamelCardGameJokerTest {
    lateinit var cardCardGameJoker: CamelCardGameJoker

    @BeforeEach
    fun setUp() {
        cardCardGameJoker = CamelCardGameJoker(readInput("day7/input_test"))
    }

    @Test
    fun getCards() {
        assertEquals(5, cardCardGameJoker.cards.count())
    }

    @Test
    fun totalBettings() {
        assertEquals(5905, cardCardGameJoker.totalBettings())
    }
}