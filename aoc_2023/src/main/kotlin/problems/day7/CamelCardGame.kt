package problems.day7

open class CamelCardGame() {
    lateinit var cards: List<CamelCard>

    constructor(lines: List<String>) : this() {
        this.cards = lines.map { line ->
            val (deck, betting) = line.split(" ")
            val values = deck.map { char ->
                CamelCard.cardTypeFromChar(char)
            }
            createCard(CamelCard(values, betting.toLong()))
        }
    }

    open fun createCard(card: CamelCard): CamelCard {
        return card
    }

    private fun sortedCards(): List<CamelCard> {

        return this.cards.sortedWith(compareBy<CamelCard> { it.handType }.thenComparing(fun(
            card1: CamelCard,
            card2: CamelCard
        ): Int {
            val deck1 = card1.ordinals()
            val deck2 = card2.ordinals()
            val firstDifferent = deck1.zip(deck2).firstOrNull {
                it.first != it.second
            } ?: Pair(0, 0)
            return firstDifferent.first - firstDifferent.second
        }))

    }

    fun totalBettings(): Long {
        return sortedCards().foldIndexed(0) { index, acc, value ->
            acc + value.betting * (index + 1)
        }
    }


}

