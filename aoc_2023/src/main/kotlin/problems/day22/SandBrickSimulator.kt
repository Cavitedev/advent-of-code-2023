package problems.day22

class SandBrickSimulator(lines: List<String>) {


    var bricks = lines.map { line ->
        val (coord1, coord2) = line.split("~").map { coordStr ->
            val splitCoord = coordStr.split(",").map { it.toLong() }
            Coordinate(splitCoord[0], splitCoord[1], splitCoord[2])
        }
        return@map Brick(coord1, coord2)
    }

    fun fallBricks() {
        val reorderedBricks = bricks.sortedBy { it.minZ() }

        val minX = reorderedBricks.minOf { it.minX() }
        val minY = reorderedBricks.minOf { it.minY() }
        val maxX = reorderedBricks.maxOf { it.maxX() }
        val maxY = reorderedBricks.maxOf { it.maxY() }

        val floorMap = mutableMapOf<Pair<Long, Long>, Floor>()

        for (x in minX..maxX) {
            for (y in minY..maxY) {
                floorMap[Pair(x, y)] = Floor(0, null)
            }
        }

        for (brick in reorderedBricks) {

            if (brick.isVertical()) {
                val floor = floorMap[Pair(brick.startCord.x, brick.startCord.y)]!!
                val difToFloor = brick.minZ() - floor.z - 1
                brick.startCord.z -= difToFloor
                brick.endCoordinate.z -= difToFloor
                floor.addBrick(brick)
                floor.brick = brick
                floor.z = brick.maxZ()
            } else {
                val positions = brick.positions()
                val floors = positions.map { pos ->
                    floorMap[Pair(pos.x, pos.y)]!!
                }
                val maxZFloor = floors.maxOf { it.z }
//                val touchingFloors = floors.filter { it.z == maxZFloor }

                val brickZ = maxZFloor + 1
                brick.startCord.z = brickZ
                brick.endCoordinate.z = brickZ

//                for (floor in touchingFloors) {
//
//                }
                for (floor in floors) {
                    if (floor.z == maxZFloor) {
                        floor.addBrick(brick)
                    }
                    floor.brick = brick
                    floor.z = brickZ
                }
            }


        }

        this.bricks = reorderedBricks
    }

    fun countBricksCanBeDisintegrated(): Int {

        return this.bricks.count { it.canBeDisintegrated() }

    }

    fun sumFallIfDisintegrate(): Int {
        return this.bricks.sumOf { it.amountThatWouldFallIfDisintegrate() }
    }

}