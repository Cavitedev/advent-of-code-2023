package problems.day23

class HikingNode(val cell: HikingCell, val gCost: Int, var previousNode: HikingNode?) {


    fun nextNode(cell: HikingCell): HikingNode {
        return HikingNode(cell, gCost + 1, this)
    }

    fun visitedCells(): Set<HikingCell> {
        var prevNode = previousNode
        val returnSet = mutableSetOf<HikingCell>()
        while (prevNode != null) {
            returnSet.add(prevNode.cell)
            prevNode = prevNode.previousNode
        }
        return returnSet
    }

    fun hasVisitedCell(): Boolean {
        val prevCells = visitedCells()
        return prevCells.contains(this.cell)
    }

}