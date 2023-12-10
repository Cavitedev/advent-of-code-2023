package problems.day10

class PipeMaze() {
    lateinit var maze: List<List<Pipe>>

    constructor(lines: List<String>) : this() {
        this.maze = lines.mapIndexed { i, line ->
            line.mapIndexed { j, char ->
                when (char) {
                    '|' -> {
                        Pipe(false, true, false, true, i, j)
                    }

                    '-' -> {
                        Pipe(true, false, true, false, i, j)
                    }

                    'L' -> {
                        Pipe(false, true, true, false, i, j)
                    }

                    'J' -> {
                        Pipe(true, true, false, false, i, j)
                    }

                    '7' -> {
                        Pipe(true, false, false, true, i, j)
                    }

                    'F' -> {
                        Pipe(false, false, true, true, i, j)
                    }

                    '.' -> {
                        Pipe(false, false, false, false, i, j)
                    }

                    'S' -> {
                        Pipe(true, true, true, true, i, j)
                    }

                    else -> {
                        Pipe(false, false, false, false, i, j)
                    }
                }
            }
        }
    }

    fun startPipe(): Pipe {
        return maze.flatten().find { it.north && it.east && it.south && it.west }!!
    }

    fun furtherstDistanceNode(): Int {
        val search = PipeSearch(this)
        return search.furtherDistanceNode()
    }

}