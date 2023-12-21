package problems.day21

class GardenWallCell(i: Int, j: Int) : GardenCell(i, j) {
    override fun canWalk(): Boolean {
        return false
    }

    override fun characterMap(step: Long): Char {
        return '#'
    }


    override fun copy(): GardenCell {
        return GardenWallCell(i, j)
    }
}