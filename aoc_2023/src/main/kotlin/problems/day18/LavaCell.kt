package problems.day18

class LavaCell(val i: Int, val j: Int, val color: Int) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is LavaCell) return false

        if (i != other.i) return false
        if (j != other.j) return false

        return true
    }

    override fun hashCode(): Int {
        var result = i
        result = 31 * result + j
        return result
    }

    override fun toString(): String {
        return "LavaCell(i=$i, j=$j, color=$color)"
    }


}