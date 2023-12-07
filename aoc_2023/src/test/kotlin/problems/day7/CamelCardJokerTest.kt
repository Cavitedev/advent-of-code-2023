package problems.day7

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CamelCardJokerTest {

    @Test
    fun getHandType() {
        val camelCard =
            CamelCardJoker(listOf(CardType.Ten, CardType.Five, CardType.Five, CardType.Joker, CardType.Five), 10)
        assertEquals(HandType.FourOfAKind, camelCard.handType)

    }

}