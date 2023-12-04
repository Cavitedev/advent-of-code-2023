package problems.day4

data class Scratchcard(val cardIndex: Int, val winningNumbers: IntArray, val playedNumbers: IntArray) {

    fun playedNumbersWon(): Set<Int> {
        return winningNumbers.toSet().intersect(playedNumbers.toSet())
    }

}