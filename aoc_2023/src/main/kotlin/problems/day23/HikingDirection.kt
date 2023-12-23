package problems.day23


abstract class HikingDirection {


    companion object {
        fun allCartesianDirs(): List<HikingDirection> = listOf(
            NorthHikingDir.getInstance(),
            EastHikingDir.getInstance(),
            SouthHikingDir.getInstance(),
            WestHikingDir.getInstance()
        )
    }

    abstract fun isHorizontal(): Boolean
    abstract fun isVertical(): Boolean
    abstract fun inverse(): HikingDirection

    abstract fun hikingType(): Char

    abstract fun nextPos(i: Int, j: Int, grid: List<List<Any>>): Pair<Int, Int>?


    fun nextPos(pair: Pair<Int, Int>, grid: List<List<Any>>): Pair<Int, Int>? {
        return nextPos(pair.first, pair.second, grid)
    }


}

class WestHikingDir : HikingDirection() {

    companion object {
        private var instance: HikingDirection? = null

        fun getInstance(): HikingDirection {
            if (instance == null) {
                instance = WestHikingDir()
            }
            return instance!!
        }
    }

    override fun isHorizontal(): Boolean {
        return true
    }

    override fun isVertical(): Boolean {
        return false
    }

    override fun inverse(): HikingDirection {
        return EastHikingDir.getInstance()
    }

    override fun hikingType(): Char {
        return 'W'
    }

    override fun nextPos(i: Int, j: Int, grid: List<List<Any>>): Pair<Int, Int>? {
        if (j == 0) return null
        return Pair(i, j - 1)
    }

    override fun hashCode(): Int {
        return 1
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is WestHikingDir) return false
        return true
    }

}

class NorthHikingDir : HikingDirection() {

    companion object {
        private var instance: HikingDirection? = null

        fun getInstance(): HikingDirection {
            if (instance == null) {
                instance = NorthHikingDir()
            }
            return instance!!
        }
    }

    override fun isHorizontal(): Boolean {
        return false
    }

    override fun isVertical(): Boolean {
        return true
    }

    override fun inverse(): HikingDirection {
        return SouthHikingDir.getInstance()
    }

    override fun hikingType(): Char {
        return 'N'
    }

    override fun nextPos(i: Int, j: Int, grid: List<List<Any>>): Pair<Int, Int>? {
        if (i == 0) return null
        return Pair(i - 1, j)
    }

    override fun hashCode(): Int {
        return 2
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is NorthHikingDir) return false
        return true
    }

}

class EastHikingDir : HikingDirection() {

    companion object {
        private var instance: HikingDirection? = null

        fun getInstance(): HikingDirection {
            if (instance == null) {
                instance = EastHikingDir()
            }
            return instance!!
        }


    }

    override fun isHorizontal(): Boolean {
        return true
    }

    override fun isVertical(): Boolean {
        return false
    }

    override fun inverse(): HikingDirection {
        return WestHikingDir.getInstance()
    }

    override fun hikingType(): Char {
        return 'E'
    }

    override fun nextPos(i: Int, j: Int, grid: List<List<Any>>): Pair<Int, Int>? {
        if (j == grid[0].size - 1) return null
        return Pair(i, j + 1)
    }

    override fun hashCode(): Int {
        return 3
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is EastHikingDir) return false
        return true
    }
}

class SouthHikingDir : HikingDirection() {

    companion object {
        private var instance: HikingDirection? = null

        fun getInstance(): HikingDirection {
            if (instance == null) {
                instance = SouthHikingDir()
            }
            return instance!!
        }
    }

    override fun isHorizontal(): Boolean {
        return false
    }

    override fun isVertical(): Boolean {
        return true
    }

    override fun inverse(): HikingDirection {
        return NorthHikingDir.getInstance()
    }

    override fun hikingType(): Char {
        return 'S'
    }

    override fun nextPos(i: Int, j: Int, grid: List<List<Any>>): Pair<Int, Int>? {
        if (i == grid.size - 1) return null
        return Pair(i + 1, j)
    }

    override fun hashCode(): Int {
        return 4
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SouthHikingDir) return false
        return true
    }

}
