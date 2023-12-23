package problems.day23

class HikingMap(lines: List<String>) {


    val map = lines.mapIndexed { i, line ->
        line.mapIndexed { j, char ->
            when (char) {
                '#' -> {
                    HikingCell(i, j, false, null)
                }

                '.' -> {
                    HikingCell(i, j, true, null)
                }

                '>' -> {
                    HikingCell(i, j, true, EastHikingDir.getInstance())
                }

                '^' -> {
                    HikingCell(i, j, true, NorthHikingDir.getInstance())
                }

                'v' -> {
                    HikingCell(i, j, true, SouthHikingDir.getInstance())
                }

                '<' -> {
                    HikingCell(i, j, true, WestHikingDir.getInstance())
                }

                else -> {
                    throw Exception("Unreachable")
                }
            }
        }
    }

    fun startCell() = this.map.first().find { it.canWalk }!!
    fun endCell() = this.map.last().find { it.canWalk }!!

    fun longestPath(): Int {
        val sol = HikingSol(this)
        return sol.solve()
    }

    fun removeSlopes() {
        this.map.flatten().forEach { cell ->
            cell.dir = null
        }
    }

}