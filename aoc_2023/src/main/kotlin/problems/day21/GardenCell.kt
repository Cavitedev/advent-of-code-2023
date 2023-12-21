package problems.day21

abstract class GardenCell(var i: Int, var j: Int) {
    abstract fun canWalk(): Boolean

    abstract fun characterMap(step: Long): Char
    abstract fun copy(): GardenCell

}