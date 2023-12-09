package problems.day9


data class SensorLine(val numbers: List<Long>) {

    val extrapolations: MutableList<List<Long>> = mutableListOf()
    fun extrapolateForward(): Long {
        return try {
            extrapolations.add(numbers)
            inlineExtrapolateForward(numbers)
        } catch (e: Exception) {
            numbers.last()
        }

    }

    private fun inlineExtrapolateForward(numbersList: List<Long>): Long {
        val extrapolation = extrapolate(numbersList)
        extrapolations.add(extrapolation)
        if (extrapolation.isEmpty()) {
            displayExtrapolations()
            throw Exception("no prediction")
        }

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

    private fun displayExtrapolations(): String {
        val initLength = extrapolations.first().size

        val output = extrapolations.map { extrapolation ->
            (" ".repeat(initLength - extrapolation.size)) + extrapolation.joinToString(" ")
        }.joinToString("\n")
        print(output)
        return output
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

//    private fun extrapolateBackwards(numbersList: List<Long>): List<Long> {
//
//        val returnList: MutableList<Long> = mutableListOf()
//
//        for (i in numbersList.size - 1 downTo 1) {
//            returnList.add(numbersList[i] - numbersList[i - 1])
//        }
//
//        return returnList
//    }


}