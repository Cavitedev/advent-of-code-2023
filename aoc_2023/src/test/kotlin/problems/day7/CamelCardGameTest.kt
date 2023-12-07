package problems.day7

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import problems.utils.readInput

class CamelCardGameTest {

    lateinit var cardCardGame: CamelCardGame

    @BeforeEach
    fun setUp() {
        cardCardGame = CamelCardGame(readInput("day7/input_test"))
    }

    @Test
    fun getCards() {
        assertEquals(5, cardCardGame.cards.count())
    }

    @Test
    fun totalBettings() {
        assertEquals(6440, cardCardGame.totalBettings())
    }
}