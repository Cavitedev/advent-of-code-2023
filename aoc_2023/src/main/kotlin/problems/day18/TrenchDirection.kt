package problems.day18

abstract class TrenchDirection {

    abstract fun isHorizontal(): Boolean
    abstract fun isVertical(): Boolean
    abstract fun inverse(): TrenchDirection

    abstract fun trenchType(): Char

    abstract fun nextPos(i: Int, j: Int): Pair<Int, Int>


    fun nextPos(pair: Pair<Int, Int>): Pair<Int, Int> {
        return nextPos(pair.first, pair.second)
    }


}

class WestTrenchDir : TrenchDirection() {

    companion object {
        private var instance: TrenchDirection? = null

        fun getInstance(): TrenchDirection {
            if (instance == null) {
                instance = WestTrenchDir()
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

    override fun inverse(): TrenchDirection {
        return EastTrenchDir.getInstance()
    }

    override fun trenchType(): Char {
        return 'W'
    }

    override fun nextPos(i: Int, j: Int): Pair<Int, Int> {
        return Pair(i, j - 1)
    }

    override fun hashCode(): Int {
        return 1
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is WestTrenchDir) return false
        return true
    }

}

class NorthTrenchDir : TrenchDirection() {

    companion object {
        private var instance: TrenchDirection? = null

        fun getInstance(): TrenchDirection {
            if (instance == null) {
                instance = NorthTrenchDir()
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

    override fun inverse(): TrenchDirection {
        return SouthTrenchDir.getInstance()
    }

    override fun trenchType(): Char {
        return 'N'
    }

    override fun nextPos(i: Int, j: Int): Pair<Int, Int> {
        return Pair(i - 1, j)
    }

    override fun hashCode(): Int {
        return 2
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is NorthTrenchDir) return false
        return true
    }

}

class EastTrenchDir : TrenchDirection() {

    companion object {
        private var instance: TrenchDirection? = null

        fun getInstance(): TrenchDirection {
            if (instance == null) {
                instance = EastTrenchDir()
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

    override fun inverse(): TrenchDirection {
        return WestTrenchDir.getInstance()
    }

    override fun trenchType(): Char {
        return 'E'
    }

    override fun nextPos(i: Int, j: Int): Pair<Int, Int> {
        return Pair(i, j + 1)
    }

    override fun hashCode(): Int {
        return 3
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is EastTrenchDir) return false
        return true
    }
}

class SouthTrenchDir : TrenchDirection() {

    companion object {
        private var instance: TrenchDirection? = null

        fun getInstance(): TrenchDirection {
            if (instance == null) {
                instance = SouthTrenchDir()
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

    override fun inverse(): TrenchDirection {
        return NorthTrenchDir.getInstance()
    }

    override fun trenchType(): Char {
        return 'S'
    }

    override fun nextPos(i: Int, j: Int): Pair<Int, Int> {
        return Pair(i + 1, j)
    }

    override fun hashCode(): Int {
        return 4
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SouthTrenchDir) return false
        return true
    }

}
