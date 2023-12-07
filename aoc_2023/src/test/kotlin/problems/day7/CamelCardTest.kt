package problems.day7

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CamelCardTest {

    @Test
    fun getHandType() {
        val camelCard =
            CamelCard(listOf(CardType.Two, CardType.Three, CardType.Three, CardType.Three, CardType.Two), 10)
        assertEquals(HandType.FullHouse, camelCard.handType)

    }
}