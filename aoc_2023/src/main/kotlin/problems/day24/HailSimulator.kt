package problems.day24

import java.math.BigDecimal
import java.math.MathContext

class HailSimulator(lines: List<String>) {

    val hailstones = lines.map { line ->
        val (cord, mov) = line.split("@").map {
            val splits = it.split(",").map { splittedCoord ->
                splittedCoord.trim().toBigDecimal(MathContext(20))
            }
            HailCoordinate(splits[0], splits[1], splits[2])
        }
        Hailstone(cord, mov)
    }

    fun intersections(): List<HailCoordinate> {
        val returnIntersections = mutableListOf<HailCoordinate>()

        for (i in 0..<this.hailstones.size) {
            for (j in i + 1..<this.hailstones.size) {
                val intersection = this.hailstones[i].intersection2D(this.hailstones[j]) ?: continue
                returnIntersections.add(intersection)
            }
        }

        return returnIntersections

    }

    fun intersectionsIn2DArea(min: BigDecimal, max: BigDecimal): List<HailCoordinate> {
        return intersections().filter {
            it.x >= min && it.x <= max &&
                    it.y >= min && it.y <= max
        }

    }


}