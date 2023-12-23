package problems.day23

class HikingCell(val i: Int, val j: Int, val canWalk: Boolean, var dir: HikingDirection?) {


    fun getNeighbours(map: List<List<Any>>): List<Pair<Int, Int>> {
        if (!canWalk) return listOf()

        val dirs = if (dir == null) HikingDirection.allCartesianDirs() else listOf(dir!!)

        return dirs.mapNotNull { it.nextPos(i, j, map) }
    }

    override fun toString(): String {
        return "$i,$j"
    }


}