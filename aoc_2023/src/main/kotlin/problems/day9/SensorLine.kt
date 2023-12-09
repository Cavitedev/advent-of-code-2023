package problems.day9


data class SensorLine(val numbers: List<Long>) {

    val extrapolations: MutableList<List<Long>> = mutableListOf()
    fun predictNextNumber(): Long {
        return try {
            extrapolations.add(numbers)
            inlinePredictNextNumber(numbers)
        } catch (e: Exception) {
            numbers.last()
        }

    }

    private fun inlinePredictNextNumber(numbersList: List<Long>): Long {
        val extrapolation = extrapolate(numbersList)
        extrapolations.add(extrapolation)
        if (extrapolation.isEmpty()) {
            displayExtrapolations()
            throw Exception("no prediction")
        }

        if (extrapolation.all { it == 0L }) {
            return numbersList.last()
        }
        return numbersList.last() + inlinePredictNextNumber(extrapolation)
    }

    private fun displayExtrapolations(): String {
        val initLength = extrapolations.first().size

        val output = extrapolations.map { extrapolation ->
            (" ".repeat(initLength - extrapolation.size)) + extrapolation.joinToString(" ")
        }.joinToString("\n")
        print(output)
        return output
    }

    private fun extrapolate(numbersList: List<Long>): List<Long> {

        val returnList: MutableList<Long> = mutableListOf()

        for (i in 0..<numbersList.size - 1) {
            returnList.add(numbersList[i + 1] - numbersList[i])
        }

        return returnList
    }


}