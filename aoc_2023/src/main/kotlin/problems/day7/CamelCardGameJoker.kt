package problems.day7

class CamelCardGameJoker(lines: List<String>) : CamelCardGame(lines) {

    override fun createCard(card: CamelCard): CamelCard {
        return CamelCardJoker(card.cards, card.betting)
    }

}