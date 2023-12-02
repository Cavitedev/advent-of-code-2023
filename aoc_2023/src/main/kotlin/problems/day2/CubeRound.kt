package problems.day2

class CubeRound(redCubes: Int, greenCubes: Int, blueCubes: Int) {

    val redCubes: Int
    val greenCubes: Int
    val blueCubes: Int

    init {
        this.redCubes = redCubes
        this.greenCubes = greenCubes
        this.blueCubes = blueCubes
    }

    fun possibleRound(maxRound: CubeRound): Boolean {
        if (this.redCubes > maxRound.redCubes) return false
        if (this.greenCubes > maxRound.greenCubes) return false
        if (this.blueCubes > maxRound.blueCubes) return false
        return true
    }

}