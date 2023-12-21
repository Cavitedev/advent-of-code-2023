package problems.day21

class GardenPlotCell(i: Int, j: Int) : GardenCell(i, j) {

    var firstStep: Int? = null

    override fun canWalk(): Boolean {
        return true
    }

    fun isInStep(step: Long): Boolean {
        if (firstStep == null) {
            return false
        }
        val firstStep = firstStep!!.toLong()
        return firstStep <= step && firstStep % 2 == step % 2
    }

    override fun characterMap(step: Long): Char {
        return if (isInStep(step)) 'O' else '.'
    }

    override fun copy(): GardenCell {
        return GardenPlotCell(i, j)
    }
}