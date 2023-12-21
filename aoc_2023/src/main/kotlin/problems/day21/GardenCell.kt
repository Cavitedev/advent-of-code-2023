package problems.day21

abstract class GardenCell(val i: Int, val j: Int) {
    abstract fun canWalk(): Boolean
}