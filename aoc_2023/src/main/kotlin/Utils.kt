import kotlin.math.abs

class Utils {
    companion object {

        fun calculateLCM(numbers: List<Long>): Long {
            if (numbers.isEmpty()) return 0L

            var lcm = numbers[0]

            for (i in 1 until numbers.size) {
                lcm = calculateLCM(lcm, numbers[i])
            }

            return lcm
        }

        fun calculateLCM(a: Long, b: Long): Long {
            val gcd = calculateGCD(a, b)
            return if (gcd != 0L) abs(a * b) / gcd else 0
        }

        fun calculateGCD(a: Long, b: Long): Long {
            var num1 = a
            var num2 = b

            while (num2 != 0L) {
                val temp = num2
                num2 = num1 % num2
                num1 = temp
            }

            return num1
        }

        val numbersRegex = Regex("""-?\d+""")

        fun numbersInLineString(line: String): List<Long> {
            return numbersRegex.findAll(line).map { it.value.toLong() }.toList()
        }
    }
}