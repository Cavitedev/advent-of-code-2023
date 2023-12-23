package problems.day23

class HikingNode(
    val cell: HikingCell,
    val gCost: Int,
    val previousNode: HikingNode?,
    val prevCells: MutableSet<HikingCell>
) {


    fun nextNode(cell: HikingCell): HikingNode {
        return HikingNode(cell, gCost + 1, this, prevCells)
    }

//    fun visitedCells(): Set<HikingCell> {
//        var prevNode = previousNode
//        val returnSet = mutableSetOf<HikingCell>()
//        while (prevNode != null) {
//            returnSet.add(prevNode.cell)
//            prevNode = prevNode.previousNode
//        }
//        return returnSet
//    }

    fun hasVisitedCell(): Boolean {
//        val prevCells = visitedCells()
        return prevCells.contains(this.cell)
    }

    fun removeUntilNode(node: HikingNode?) {
        if (node == null) return
        var prevNode: HikingNode? = this
        do {
            if (prevNode == null) {
                return
            }
            prevCells.remove(prevNode.cell)
            prevNode = prevNode.previousNode
        } while (prevNode?.cell != node.cell)

    }


}