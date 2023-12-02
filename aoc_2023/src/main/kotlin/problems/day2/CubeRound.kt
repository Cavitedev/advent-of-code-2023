package problems.day2

import kotlin.math.max

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

    fun powerSet(): Int {
        return this.redCubes * this.greenCubes * this.blueCubes
    }

    fun combineMinimumSet(cubeRound: CubeRound): CubeRound {
        return CubeRound(
            max(this.redCubes, cubeRound.redCubes),
            max(this.greenCubes, cubeRound.greenCubes),
            max(this.blueCubes, cubeRound.blueCubes)
        )
    }


    override fun toString(): String {
        return "CubeRound(redCubes=$redCubes, greenCubes=$greenCubes, blueCubes=$blueCubes)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CubeRound) return false

        if (redCubes != other.redCubes) return false
        if (greenCubes != other.greenCubes) return false
        if (blueCubes != other.blueCubes) return false

        return true
    }

    override fun hashCode(): Int {
        var result = redCubes
        result = 31 * result + greenCubes
        result = 31 * result + blueCubes
        return result
    }


}