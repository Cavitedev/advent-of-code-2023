package problems.day22

import kotlin.math.max
import kotlin.math.min

class Brick(val startCord: Coordinate, val endCoordinate: Coordinate) {

    var aboveBricks = mutableSetOf<Brick>()
    var downBricks = mutableSetOf<Brick>()


    fun canBeDisintegrated(): Boolean {
        return aboveBricks.all { it.downBricks.size >= 2 }
    }

    fun isVertical(): Boolean = startCord.x == endCoordinate.x && startCord.y == endCoordinate.y

    fun positions(): List<Coordinate> {
        val coordinates = mutableListOf<Coordinate>()
        for (x in startCord.x..endCoordinate.x) {
            for (y in startCord.y..endCoordinate.y) {
                for (z in startCord.z..endCoordinate.z) {
                    coordinates.add(Coordinate(x, y, z))
                }
            }
        }
        return coordinates
    }

    fun minZ(): Long {
        return min(startCord.z, endCoordinate.z)
    }


    fun minX(): Long {
        return min(startCord.x, endCoordinate.x)
    }

    fun minY(): Long {
        return min(startCord.y, endCoordinate.y)
    }

    fun maxX(): Long {
        return max(startCord.x, endCoordinate.x)
    }

    fun maxY(): Long {
        return max(startCord.y, endCoordinate.y)
    }

    fun maxZ(): Long {
        return max(startCord.z, endCoordinate.z)
    }

    override fun toString(): String {
        return "$startCord~$endCoordinate"
    }


}