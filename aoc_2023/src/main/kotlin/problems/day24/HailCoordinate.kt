package problems.day24

class HailCoordinate(val x: Long, val y: Long, val z: Long) {


    override fun toString(): String {
        return "$x,$y,$z"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is HailCoordinate) return false

        if (x != other.x) return false
        if (y != other.y) return false
        if (z != other.z) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        result = 31 * result + z.hashCode()
        return result
    }


}