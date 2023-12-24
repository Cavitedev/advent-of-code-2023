package problems.day24

class HailSimulator(lines: List<String>) {

    val hailstones = lines.map { line ->
        val (cord, mov) = line.split("@").map {
            val splits = it.split(",").map { splittedCoord ->
                splittedCoord.trim().toLong()
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

    fun intersectionsIn2DArea(min: Long, max: Long): List<HailCoordinate> {
        return intersections().filter {
            it.x >= min && it.x <= max &&
                    it.y >= min && it.y <= max
        }

    }


}