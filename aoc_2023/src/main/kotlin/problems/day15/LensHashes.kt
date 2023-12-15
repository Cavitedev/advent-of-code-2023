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


}