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

    fun intersectionsXY(): List<HailCoordinate> {
        val returnIntersections = mutableListOf<HailCoordinate>()

        for (i in 0..<this.hailstones.size) {
            for (j in i + 1..<this.hailstones.size) {
                val intersection = this.hailstones[i].intersectionXY(this.hailstones[j]) ?: continue
                returnIntersections.add(intersection)
            }
        }

        return returnIntersections

    }

    fun intersectionsIn2DArea(min: BigDecimal, max: BigDecimal): List<HailCoordinate> {
        return intersectionsXY().filter {
            it.x >= min && it.x <= max &&
                    it.y >= min && it.y <= max
        }

    }

    fun firstPlane(): HailPlane {

        for (i in 0..<this.hailstones.size) {
            for (j in i + 1..<this.hailstones.size) {
                val plane = this.hailstones[i].planeParalelLines(this.hailstones[j]) ?: continue
                return plane
            }
        }

        throw Exception("Unreachable")

    }

    fun rockThrown(): Hailstone {
        val plane = firstPlane()
        val usedHailstones = mutableListOf<Hailstone>()
        val intersections = mutableListOf<HailCoordinate>()

        for (hailstone in hailstones) {
            try {
                val planes = hailstone.toPlanes()
                val intersection = plane.intersection(planes[0], planes[1])
                intersections.add(intersection)
                usedHailstones.add(hailstone)
            } catch (e: ArithmeticException) {

            }
            if (intersections.size >= 2) break
        }

//        val planesHailStones = this.hailstones.take(2).map { it.toPlanes() }
//        val intersections = planesHailStones.map { plane.intersection(it[0], it[1]) }
        val timeIntersection1 = (intersections[0].x - usedHailstones[0].pos.x) / usedHailstones[0].vel.x
        val timeIntersection2 = (intersections[1].x - usedHailstones[1].pos.x) / usedHailstones[1].vel.x

        if (timeIntersection1 < timeIntersection2) {
            val speed = intersections[1].subtract(intersections[0])
            val startPos = intersections[0].subtract(speed.multiply(timeIntersection1))
            return Hailstone(startPos, speed)
        } else {
            val speed = intersections[0].subtract(intersections[1])
            val startPos = intersections[1].subtract(speed.multiply(timeIntersection1))
            return Hailstone(startPos, speed)
        }


    }

}