package problems.day15

class LensHashes(lines: List<String>) {
    val sequences = lines[0].split(",")

    fun stepIntoValue(step: Char, value: Int): Int {
        val charCode = step.code
        return ((value + charCode) * 17) % 256
    }

    fun sequenceIntoValue(sequence: String, value: Int): Int {
        var returnValue = value
        for (char in sequence) {
            returnValue = stepIntoValue(char, returnValue)
        }
        return returnValue
    }

    fun sumHashResults(): Long {
        var total = 0L
        for (sequence in sequences) {
            val value = sequenceIntoValue(sequence, 0)
            total += value
        }
        return total
    }

    fun focusingPower(): Long {
        val boxes = calculatesBoxes()
        return boxes.foldIndexed(0L) { index, acc, box ->
            acc + box.foldIndexed(0L) { index2, acc2, elementBox ->
                acc2 + (index + 1) * (index2 + 1) * elementBox.second
            }
        }
    }

    fun calculatesBoxes(): List<List<Pair<String, Int>>> {
        val returnArray: MutableList<MutableList<Pair<String, Int>>> = MutableList(256) { mutableListOf() }

        for (sequence in sequences) {
            val splitSequence = sequence.split("-", "=")
            val code = sequenceIntoValue(splitSequence[0], 0)

            // -
            if (splitSequence[1] == "") {
                returnArray[code].removeIf { it.first == splitSequence[0] }
            }
            // =
            else {
                val boxToAdd = splitSequence[1].toInt()
                val findIndex = returnArray[code].indexOfFirst { it.first == splitSequence[0] }
                val updatePair = Pair(splitSequence[0], boxToAdd)
                if (findIndex != -1) {
                    returnArray[code][findIndex] = updatePair
                } else {
                    returnArray[code].add(updatePair)
                }

            }
        }

        return returnArray
    }

}