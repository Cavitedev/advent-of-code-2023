package problems.day14

class ParabolicDish(var lines: List<String>) {


    fun tiltOnce(direction: TiltDirection) {
        lines = direction.tilt(lines)
    }

    fun sumLoad(): Long {
        return this.lines.foldIndexed(0L) { index, acc, line ->
            val value = (this.lines.size - index).toLong()
            acc + line.count { it == 'O' }.toLong() * value
        }

    }

}