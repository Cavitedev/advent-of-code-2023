package problems.day22

data class Floor(var z: Long, var brick: Brick?) {

    fun addBrick(otherBrick: Brick) {
        if (brick != null) {
            otherBrick.downBricks.add(brick!!)
            brick!!.aboveBricks.add(otherBrick)
        }
    }
}