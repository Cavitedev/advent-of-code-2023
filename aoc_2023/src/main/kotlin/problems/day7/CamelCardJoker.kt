package problems.day7

class CamelCardJoker(cards: List<CardType>, betting: Long) : CamelCard(cards, betting) {

    override fun init() {
        val counts = cards.groupingBy { it }.eachCount().toMutableMap()
        if (counts.containsKey(CardType.Joker)) {
            val jokerTimes = counts.remove(CardType.Joker) ?: 0
            val maxValueEntry = counts.entries.maxByOrNull { it.value }
            if (maxValueEntry == null) {
                counts[CardType.Joker] = 5
            } else {
                counts[maxValueEntry.key] = maxValueEntry.value + jokerTimes
            }
        }

        assignHandTypeFromCounts(counts)
    }


    override fun ordinals(
    ): List<Int> {
        return cards.map {
            if (it == CardType.Joker) {
                -1
            } else {
                it.ordinal
            }
        }
    }
}