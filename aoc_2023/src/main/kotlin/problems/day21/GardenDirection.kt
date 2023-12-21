package problems.day21

abstract class GardenDirection {

    companion object {
        fun allCartesianDirs(): List<GardenDirection> = listOf(
            NorthGardenDir.getInstance(),
            EastGardenDir.getInstance(),
            SouthGardenDir.getInstance(),
            WestGardenDir.getInstance()
        )

        fun allRomboDirs(): List<GardenDirection> = listOf(
            NorthWestGardenDir.getInstance(),
            NorthEastGardenDir.getInstance(),
            SouthWestGardenDir.getInstance(),
            SouthEastGardenDir.getInstance()
        )
    }


    abstract fun nextPos(i: Int, j: Int, grid: List<List<Any>>): Pair<Int, Int>?

    abstract fun <T> edgeElements(grid: List<List<T>>): Pair<T, T>

}

class WestGardenDir : GardenDirection() {

    companion object {
        private var instance: GardenDirection? = null

        fun getInstance(): GardenDirection {
            if (instance == null) {
                instance = WestGardenDir()
            }
            return instance!!
        }
    }


    override fun nextPos(i: Int, j: Int, grid: List<List<Any>>): Pair<Int, Int>? {
        if (j == 0) return null
        return Pair(i, j - 1)
    }

    override fun <T> edgeElements(grid: List<List<T>>): Pair<T, T> {
        val middle = grid.size / 2

        return Pair(grid[middle][0], grid[middle][1])
    }

    override fun hashCode(): Int {
        return 1
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is WestGardenDir) return false
        return true
    }

}

class NorthGardenDir : GardenDirection() {

    companion object {
        private var instance: GardenDirection? = null

        fun getInstance(): GardenDirection {
            if (instance == null) {
                instance = NorthGardenDir()
            }
            return instance!!
        }
    }


    override fun nextPos(i: Int, j: Int, grid: List<List<Any>>): Pair<Int, Int>? {
        if (i == 0) return null
        return Pair(i - 1, j)
    }

    override fun <T> edgeElements(grid: List<List<T>>): Pair<T, T> {
        val middle = grid[0].size / 2

        return Pair(grid[0][middle], grid[1][middle])
    }

    override fun hashCode(): Int {
        return 2
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is NorthGardenDir) return false
        return true
    }

}

class EastGardenDir : GardenDirection() {

    companion object {
        private var instance: GardenDirection? = null

        fun getInstance(): GardenDirection {
            if (instance == null) {
                instance = EastGardenDir()
            }
            return instance!!
        }


    }


    override fun nextPos(i: Int, j: Int, grid: List<List<Any>>): Pair<Int, Int>? {
        if (j == grid[0].size - 1) return null
        return Pair(i, j + 1)
    }

    override fun <T> edgeElements(grid: List<List<T>>): Pair<T, T> {
        val middle = grid[0].size / 2
        val last = grid.size - 1

        return Pair(grid[last][middle], grid[last - 1][middle])
    }

    override fun hashCode(): Int {
        return 3
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is EastGardenDir) return false
        return true
    }
}

class SouthGardenDir : GardenDirection() {

    companion object {
        private var instance: GardenDirection? = null

        fun getInstance(): GardenDirection {
            if (instance == null) {
                instance = SouthGardenDir()
            }
            return instance!!
        }
    }


    override fun nextPos(i: Int, j: Int, grid: List<List<Any>>): Pair<Int, Int>? {
        if (i == grid.size - 1) return null
        return Pair(i + 1, j)
    }

    override fun <T> edgeElements(grid: List<List<T>>): Pair<T, T> {
        val middle = grid.size / 2
        val last = grid.size - 1
        return Pair(grid[middle][last], grid[middle][last - 1])
    }

    override fun hashCode(): Int {
        return 4
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SouthGardenDir) return false
        return true
    }

}


class NorthWestGardenDir : GardenDirection() {

    companion object {
        private var instance: GardenDirection? = null

        fun getInstance(): GardenDirection {
            if (instance == null) {
                instance = NorthWestGardenDir()
            }
            return instance!!
        }
    }

    override fun nextPos(i: Int, j: Int, grid: List<List<Any>>): Pair<Int, Int>? {
        TODO("Not yet implemented")
    }

    override fun <T> edgeElements(grid: List<List<T>>): Pair<T, T> {
        return Pair(grid[0][0], grid[1][0])
    }

}

class NorthEastGardenDir : GardenDirection() {

    companion object {
        private var instance: GardenDirection? = null

        fun getInstance(): GardenDirection {
            if (instance == null) {
                instance = NorthEastGardenDir()
            }
            return instance!!
        }
    }

    override fun nextPos(i: Int, j: Int, grid: List<List<Any>>): Pair<Int, Int>? {
        TODO("Not yet implemented")
    }

    override fun <T> edgeElements(grid: List<List<T>>): Pair<T, T> {
        val lastCol = grid[0].size - 1
        return Pair(grid[0][lastCol], grid[1][lastCol])
    }

}

class SouthWestGardenDir : GardenDirection() {

    companion object {
        private var instance: GardenDirection? = null

        fun getInstance(): GardenDirection {
            if (instance == null) {
                instance = SouthWestGardenDir()
            }
            return instance!!
        }
    }

    override fun nextPos(i: Int, j: Int, grid: List<List<Any>>): Pair<Int, Int>? {
        TODO("Not yet implemented")
    }

    override fun <T> edgeElements(grid: List<List<T>>): Pair<T, T> {
        val lastRow = grid.size - 1
        return Pair(grid[lastRow][0], grid[lastRow - 1][0])
    }

}


class SouthEastGardenDir : GardenDirection() {

    companion object {
        private var instance: GardenDirection? = null

        fun getInstance(): GardenDirection {
            if (instance == null) {
                instance = SouthEastGardenDir()
            }
            return instance!!
        }
    }

    override fun nextPos(i: Int, j: Int, grid: List<List<Any>>): Pair<Int, Int>? {
        TODO("Not yet implemented")
    }

    override fun <T> edgeElements(grid: List<List<T>>): Pair<T, T> {
        val lastCol = grid[0].size - 1
        val lastRow = grid.size - 1
        return Pair(grid[lastRow][lastCol], grid[lastRow - 1][lastCol])
    }

}
