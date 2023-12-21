package problems.day21

class GardenPlotCell(i: Int, j: Int) : GardenCell(i, j) {

    var firstStep: Int? = null

    override fun canWalk(): Boolean {
        return true
    }
}