package problems.day17

class CrucibleNode(
    val i: Int,
    val j: Int,
    val gCost: Int,
    hCost: Int,
    val dir: CrucibleDirection,
    val lastNode: CrucibleNode?
) {

    val fCost = gCost + hCost

    fun repeatedDirs(): Int {
        var repeats = 1
        var nextLastNode = lastNode
        while (nextLastNode != null && nextLastNode.dir == dir) {
            repeats++
            nextLastNode = nextLastNode.lastNode
        }
        return repeats
    }

    fun generateNextNode(i: Int, j: Int, addCost: Int, hCost: Int, dir: CrucibleDirection): CrucibleNode {
        return CrucibleNode(i, j, gCost + addCost, hCost, dir, this)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CrucibleNode) return false

        if (i != other.i) return false
        if (j != other.j) return false
        if (dir != other.dir) return false
        if (repeatedDirs() != other.repeatedDirs()) return false

        return true
    }

    override fun hashCode(): Int {
        var result = i
        result = 31 * result + j
        result = 31 * result + repeatedDirs()
        result = 31 * result + dir.hashCode()
        return result
    }


}