package problems.day14

class ParabolicDish(readLines: List<String>) {

    var lines = readLines.map { it.toList() }

    fun tiltOnce(direction: TiltDirection) {
        lines = direction.tilt(lines)
    }

    fun tiltCycle() {
        var tilt = NorthTiltDirection.getInstance().tilt(lines)
        tilt = WestTiltDirection.getInstance().tilt(tilt)
        tilt = SouthTiltDirection.getInstance().tilt(tilt)
        tilt = EastTiltDirection.getInstance().tilt(tilt)
        this.lines = tilt
    }

    fun tiltCycles(n: Long) {
        val previousCycles = mutableMapOf<List<List<Char>>, Int>()
        var index = 0
        previousCycles[this.lines] = index
        while (index < n) {
            index++
            this.tiltCycle()
            val previousCycle = previousCycles[this.lines]
            if (previousCycle != null) {
                // Calc final cycle
                val repeatAmount = index - previousCycle
                val actualIndex = (n - index) % repeatAmount + previousCycle

                val situationAtIndex = previousCycles.toList().find {
                    it.second == actualIndex.toInt()
                }!!.first
                this.lines = situationAtIndex
                return
            }
            previousCycles[this.lines] = index
        }

    }

    fun sumLoad(): Long {
        return this.lines.foldIndexed(0L) { index, acc, line ->
            val value = (this.lines.size - index).toLong()
            acc + line.count { it == 'O' }.toLong() * value
        }

    }

}