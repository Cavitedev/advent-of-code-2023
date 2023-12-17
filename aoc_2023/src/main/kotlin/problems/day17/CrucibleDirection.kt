package problems.day17

abstract class CrucibleDirection {

    abstract fun isHorizontal(): Boolean
    abstract fun isVertical(): Boolean

    abstract fun crucibleType(): Char

    abstract fun nextPos(i: Int, j: Int, grid: List<List<Any>>): Pair<Int, Int>?

    abstract fun rotateClockwise(): CrucibleDirection
    abstract fun rotateAntiClockwise(): CrucibleDirection
}

class WestCrucibleDir : CrucibleDirection() {

    companion object {
        private var instance: CrucibleDirection? = null

        fun getInstance(): CrucibleDirection {
            if (instance == null) {
                instance = WestCrucibleDir()
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

    override fun crucibleType(): Char {
        return 'W'
    }

    override fun nextPos(i: Int, j: Int, grid: List<List<Any>>): Pair<Int, Int>? {
        if (j == 0) return null
        return Pair(i, j - 1)
    }

    override fun rotateClockwise(): CrucibleDirection {
        return NorthCrucibleDir.getInstance()
    }

    override fun rotateAntiClockwise(): CrucibleDirection {
        return SouthCrucibleDir.getInstance()
    }

}

class NorthCrucibleDir : CrucibleDirection() {

    companion object {
        private var instance: CrucibleDirection? = null

        fun getInstance(): CrucibleDirection {
            if (instance == null) {
                instance = NorthCrucibleDir()
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

    override fun crucibleType(): Char {
        return 'N'
    }

    override fun nextPos(i: Int, j: Int, grid: List<List<Any>>): Pair<Int, Int>? {
        if (i == 0) return null
        return Pair(i - 1, j)
    }

    override fun rotateClockwise(): CrucibleDirection {
        return EastCrucibleDir.getInstance()
    }

    override fun rotateAntiClockwise(): CrucibleDirection {
        return WestCrucibleDir.getInstance()
    }

}

class EastCrucibleDir : CrucibleDirection() {

    companion object {
        private var instance: CrucibleDirection? = null

        fun getInstance(): CrucibleDirection {
            if (instance == null) {
                instance = EastCrucibleDir()
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

    override fun crucibleType(): Char {
        return 'E'
    }

    override fun nextPos(i: Int, j: Int, grid: List<List<Any>>): Pair<Int, Int>? {
        if (j == grid[0].size - 1) return null
        return Pair(i, j + 1)
    }

    override fun rotateClockwise(): CrucibleDirection {
        return SouthCrucibleDir.getInstance()
    }

    override fun rotateAntiClockwise(): CrucibleDirection {
        return NorthCrucibleDir.getInstance()
    }
}

class SouthCrucibleDir : CrucibleDirection() {

    companion object {
        private var instance: CrucibleDirection? = null

        fun getInstance(): CrucibleDirection {
            if (instance == null) {
                instance = SouthCrucibleDir()
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

    override fun crucibleType(): Char {
        return 'S'
    }

    override fun nextPos(i: Int, j: Int, grid: List<List<Any>>): Pair<Int, Int>? {
        if (i == grid.size - 1) return null
        return Pair(i + 1, j)
    }

    override fun rotateClockwise(): CrucibleDirection {
        return WestCrucibleDir.getInstance()
    }

    override fun rotateAntiClockwise(): CrucibleDirection {
        return EastCrucibleDir.getInstance()
    }

}
