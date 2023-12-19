package problems.day19

data class Part(val x: Int, val m: Int, val a: Int, val s: Int) {

    fun valChar(char: Char): Int {
        return when (char) {
            'x' -> {
                x
            }

            'm' -> {
                m
            }

            'a' -> {
                a
            }

            's' -> {
                s
            }

            else -> {
                0
            }
        }
    }

    fun totalAmount(): Int {
        return x + m + a + s
    }

}