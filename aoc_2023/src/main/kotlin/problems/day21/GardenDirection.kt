package problems.day21

abstract class GardenDirection {

    companion object {
        fun allDirs(): List<GardenDirection> = listOf(
            NorthGardenDir.getInstance(),
            EastGardenDir.getInstance(),
            SouthGardenDir.getInstance(),
            WestGardenDir.getInstance()
        )
    }

    abstract fun isHorizontal(): Boolean
    abstract fun isVertical(): Boolean
    abstract fun inverse(): GardenDirection

    abstract fun gardenType(): Char

    abstract fun nextPos(i: Int, j: Int, grid: List<List<Any>>): Pair<Int, Int>?


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

    override fun isHorizontal(): Boolean {
        return true
    }

    override fun isVertical(): Boolean {
        return false
    }

    override fun inverse(): GardenDirection {
        return EastGardenDir.getInstance()
    }

    override fun gardenType(): Char {
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

    override fun isHorizontal(): Boolean {
        return false
    }

    override fun isVertical(): Boolean {
        return true
    }

    override fun inverse(): GardenDirection {
        return SouthGardenDir.getInstance()
    }

    override fun gardenType(): Char {
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

    override fun isHorizontal(): Boolean {
        return true
    }

    override fun isVertical(): Boolean {
        return false
    }

    override fun inverse(): GardenDirection {
        return WestGardenDir.getInstance()
    }

    override fun gardenType(): Char {
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

    override fun isHorizontal(): Boolean {
        return false
    }

    override fun isVertical(): Boolean {
        return true
    }

    override fun inverse(): GardenDirection {
        return NorthGardenDir.getInstance()
    }

    override fun gardenType(): Char {
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
        if (other !is SouthGardenDir) return false
        return true
    }

}
