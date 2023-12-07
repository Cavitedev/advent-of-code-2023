package problems.day7


open class CamelCard(val cards: List<CardType>, val betting: Long) {

    lateinit var handType: HandType

    init {
        this.init()
    }

    open fun init() {
        val counts = cards.groupingBy { it }.eachCount()
        assignHandTypeFromCounts(counts)
    }

    open fun ordinals(
    ): List<Int> {
        return cards.map { it.ordinal }
    }


    fun assignHandTypeFromCounts(counts: Map<CardType, Int>) {
        val firstElementAmount = counts.entries.first().value

        this.handType = when (counts.count()) {
            1 -> HandType.FiveOfAKind
            2 -> if (firstElementAmount == 2 || firstElementAmount == 3) HandType.FullHouse else HandType.FourOfAKind
            3 -> if (counts.values.contains(3)) HandType.ThreeOfAKind else HandType.TwoPair
            4 -> HandType.OnePair
            else -> HandType.HighCard
        }
    }

    companion object {
        fun cardTypeFromChar(char: Char): CardType {
            return when (char) {
                '2' -> CardType.Two
                '3' -> CardType.Three
                '4' -> CardType.Four
                '5' -> CardType.Five
                '6' -> CardType.Six
                '7' -> CardType.Seven
                '8' -> CardType.Eight
                '9' -> CardType.Nine
                'T' -> CardType.Ten
                'J' -> CardType.Joker
                'Q' -> CardType.Queen
                'K' -> CardType.King

                else -> CardType.Ace
            }
        }
    }
}