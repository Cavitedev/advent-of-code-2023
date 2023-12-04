package problems.day4

import kotlin.math.pow


class Scratchcards(val scratchcards: Array<Scratchcard>) {

    companion object {
        fun fromLines(lines: List<String>): Scratchcards {

            val scratchcards: Array<Scratchcard> = lines.map { line ->
                val (card, numbers) = line.split(':')
                val cardIndex = card.split(" ").last().toInt()
                val (winningNumbersStr, playedNumbersStr) = numbers.split('|')

                val numbersRegex = Regex("""(\d+)""")
                val winningNumbers: IntArray = numbersRegex.findAll(winningNumbersStr).map { numberStr ->
                    numberStr.value.toInt()
                }.toList().toIntArray()

                val playedNumbers: IntArray = numbersRegex.findAll(playedNumbersStr).map { numberStr ->
                    numberStr.value.toInt()
                }.toList().toIntArray()

                Scratchcard(cardIndex, winningNumbers, playedNumbers)
            }.toTypedArray()

            return Scratchcards(scratchcards)
        }
    }

    fun sumWinningPoints(): Int {
        return scratchcards.map { 2.0.pow(it.playedNumbersWon().count() - 1.0).toInt() }.fold(0) { acc, points ->
            acc + points
        }

    }

    fun sumNumberOfCopies(): Int {

        val timesToPlayEachCard = IntArray(this.scratchcards.count()) { 1 }


        for (timePlayCardIndex in timesToPlayEachCard.indices) {
            val timePlayCard = timesToPlayEachCard[timePlayCardIndex]
            val card = scratchcards[timePlayCardIndex]
            val wonNumbers = card.playedNumbersWon()
            for (i in wonNumbers.indices) {
                timesToPlayEachCard[timePlayCardIndex + i + 1] += timePlayCard
            }
        }

        return timesToPlayEachCard.reduce { pre, cur ->
            pre + cur
        }
    }

}