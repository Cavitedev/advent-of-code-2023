package problems.day21

class ExpandInDirection(var sequenceValues: MutableList<Int>, var start: Int, var startDif: Int) {


    companion object {
        fun fromLastCellsGroups(
            cellsLast: List<List<GardenCell>>,
            cellsSecondToLast: List<List<GardenCell>>,
            maxValue: Int
        ): ExpandInDirection {
            val firstStepSecondToLast = Garden.firstStep(cellsSecondToLast)
            val firstStepLast = Garden.firstStep(cellsLast)
            val sequenceList = mutableListOf<Int>()

            var step = firstStepLast.toLong()
            do {
                val calc = Garden.countPlotsAtStep(cellsLast, step)
                sequenceList.add(calc)
                step++
            } while (calc != maxValue)
            return ExpandInDirection(sequenceList, firstStepLast, firstStepLast - firstStepSecondToLast)
        }
    }

    fun edgeTotalAmount(steps: Long): Long {

        var total = 0L
        val difSteps = steps - start
        if (difSteps < 0) return 0L
        var step = difSteps % startDif
        while (step < sequenceValues.size) {
            total += sequenceValues[step.toInt()]
            step += startDif
            if (difSteps < this.sequenceValues.size)
                break
        }

        return total
    }

    fun innerEdgesTotalAmount(steps: Long, large: Int, secondLarge: Int): Long {
        var total = 0L
        val difSteps = steps - start
        if (difSteps < 0) return 0L
        var step = difSteps % startDif + startDif
        while (step < sequenceValues.size) {
            step += startDif
        }
        var innerStep = difSteps - step

        while (innerStep > 0) {
            total += if (innerStep % 2 == 0L) secondLarge else large
            innerStep -= startDif
        }

        return total
    }

    fun cornerTotalAmount(steps: Long, inputSize: Int): Long {

        val halfSize = inputSize / 2

        var total = 0L
        val difSteps = steps - start + (startDif * halfSize)
        if (difSteps < 0) return 0
        var step = difSteps % startDif
        var timesDif = (difSteps / startDif)

        if (difSteps < startDif * inputSize / 2) {
            timesDif -= 1
        }

        while (step < sequenceValues.size && timesDif > -2) {
            if (difSteps < startDif * inputSize / 2) {
                timesDif -= 2
            } else {
                timesDif--
            }
            total += sequenceValues[step.toInt()] * (timesDif + halfSize)
            step += startDif
        }

        return total
    }


    fun innerCornersTotalAmount(steps: Long, large: Int, secondLarge: Int, inputSize: Int): Long {
        val halfSize = inputSize / 2

        var total = 0L
        val difSteps = steps - start + (startDif * halfSize)
        if (difSteps < 0) return 0L
        var timesDif = (difSteps / startDif)
        var step = difSteps % startDif
        while (step < sequenceValues.size) {
            step += startDif
            timesDif--
        }
        var innerStep = difSteps - step

        while (innerStep > 0) {
            total += (if (innerStep % 2 == 0L) secondLarge else large) * (timesDif + inputSize / 2 - 1)
            innerStep -= startDif
            if (innerStep <= startDif * inputSize / 2) {
                timesDif -= 2
            } else {
                timesDif--
            }
        }

        return total
    }

}