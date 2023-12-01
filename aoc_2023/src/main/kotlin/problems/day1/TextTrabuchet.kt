package problems.day1

class TextTrabuchet(input: String) : Trabuchet(input) {


    val extraOptionsMapper = mapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5,
        "six" to 6,
        "seven" to 7,
        "eight" to 8,
        "nine" to 9
    )

    override fun getOptionsMapper(): Map<String, Int> {
        val originalMapper = super.getOptionsMapper()
        return originalMapper.plus(extraOptionsMapper)
    }

}