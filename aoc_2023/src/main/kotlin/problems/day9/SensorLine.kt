package problems.day9


data class SensorLine(val numbers: List<Long>) {

    fun extrapolateForward(): Long {
        return inlineExtrapolateForward(numbers)
    }

    private fun inlineExtrapolateForward(numbersList: List<Long>): Long {
        val extrapolation = extrapolate(numbersList)

        if (extrapolation.all { it == 0L }) {
            return numbersList.last()
        }
        return numbersList.last() + inlineExtrapolateForward(extrapolation)
    }


    private fun extrapolate(numbersList: List<Long>): List<Long> {

        val returnList: MutableList<Long> = mutableListOf()

        for (i in 0..<numbersList.size - 1) {
            returnList.add(numbersList[i + 1] - numbersList[i])
        }

        return returnList
    }

    fun extrapolateBackward(): Long {
        return inlineExtrapolateBackward(numbers)
    }

    private fun inlineExtrapolateBackward(numbersList: List<Long>): Long {
        val extrapolation = extrapolate(numbersList)
        if (extrapolation.all { it == 0L }) {
            return numbersList.first()
        }
        return numbersList.first() - inlineExtrapolateBackward(extrapolation)
    }


}