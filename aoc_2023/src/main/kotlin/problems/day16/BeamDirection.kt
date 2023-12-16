package problems.day16

import problems.day16.cells.MirrorCellType

abstract class BeamDirection {

    abstract fun isHorizontal(): Boolean
    abstract fun isVertical(): Boolean

    abstract fun beamType(): Char

    abstract fun nextPos(i: Int, j: Int, grid: List<List<MirrorCellType>>): Pair<Int, Int>?

}

class WestBeamDir : BeamDirection() {

    companion object {
        private var instance: BeamDirection? = null

        fun getInstance(): BeamDirection {
            if (instance == null) {
                instance = WestBeamDir()
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

    override fun beamType(): Char {
        return 'W'
    }

    override fun nextPos(i: Int, j: Int, grid: List<List<MirrorCellType>>): Pair<Int, Int>? {
        if (j == 0) return null
        return Pair(i, j - 1)
    }

}

class NorthBeamDir : BeamDirection() {

    companion object {
        private var instance: BeamDirection? = null

        fun getInstance(): BeamDirection {
            if (instance == null) {
                instance = NorthBeamDir()
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

    override fun beamType(): Char {
        return 'N'
    }

    override fun nextPos(i: Int, j: Int, grid: List<List<MirrorCellType>>): Pair<Int, Int>? {
        if (i == 0) return null
        return Pair(i - 1, j)
    }

}

class EastBeamDir : BeamDirection() {

    companion object {
        private var instance: BeamDirection? = null

        fun getInstance(): BeamDirection {
            if (instance == null) {
                instance = EastBeamDir()
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

    override fun beamType(): Char {
        return 'E'
    }

    override fun nextPos(i: Int, j: Int, grid: List<List<MirrorCellType>>): Pair<Int, Int>? {
        if (j == grid[0].size - 1) return null
        return Pair(i, j + 1)
    }
}

class SouthBeamDir : BeamDirection() {

    companion object {
        private var instance: BeamDirection? = null

        fun getInstance(): BeamDirection {
            if (instance == null) {
                instance = SouthBeamDir()
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

    override fun beamType(): Char {
        return 'S'
    }

    override fun nextPos(i: Int, j: Int, grid: List<List<MirrorCellType>>): Pair<Int, Int>? {
        if (i == grid.size - 1) return null
        return Pair(i + 1, j)
    }

}
