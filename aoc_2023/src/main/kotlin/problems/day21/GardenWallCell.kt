package problems.day21

class GardenWallCell(i: Int, j: Int) : GardenCell(i, j) {
    override fun canWalk(): Boolean {
        return false
    }

}