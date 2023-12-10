package problems.day10

class PipeSearch(val pipeMaze: PipeMaze) {

    val outerTilesSet = mutableSetOf<Pipe>()
    val squeezePipesSet = mutableSetOf<SqueezePipes>()
    val pendingCheckTiles = mutableListOf<Pipe>()

    fun outerTiles(): Set<Pipe> {


        for (row in 0..<pipeMaze.maze.size) {
            pendingCheckTiles.add(pipeMaze.maze[row][0])
            pendingCheckTiles.add(pipeMaze.maze[row][pipeMaze.maze[0].size - 1])
        }

        for (col in 1..<pipeMaze.maze[0].size - 1) {
            pendingCheckTiles.add(pipeMaze.maze[0][col])
            pendingCheckTiles.add(pipeMaze.maze[pipeMaze.maze.size - 1][col])
        }

        while (pendingCheckTiles.isNotEmpty()) {
            val nextTile = pendingCheckTiles.removeAt(0)
            connectOuterTile(nextTile)
        }

        return outerTilesSet
    }

    private fun connectOuterTile(tile: Pipe) {
        if (outerTilesSet.contains(tile) || pipeMaze.mainLoop.contains(tile))
            return
        outerTilesSet.add(tile)

        val neighbours = tile.getSqueezePipes(pipeMaze)
        neighbours.forEach { connectSqueezePipes(it) }

    }

    private fun connectSqueezePipes(squeeze: SqueezePipes) {
        if (squeezePipesSet.contains(squeeze)) {
            return
        } else {
            squeezePipesSet.add(squeeze)
        }

        var newOuterTile = false

        if (!pipeMaze.mainLoop.contains(squeeze.pipe1) && !outerTilesSet.contains(squeeze.pipe1)) {
            pendingCheckTiles.add(squeeze.pipe1)
            newOuterTile = true
        }
        if (!pipeMaze.mainLoop.contains(squeeze.pipe2) && !outerTilesSet.contains(squeeze.pipe2)) {
            pendingCheckTiles.add(squeeze.pipe2)
            newOuterTile = true
        }
        if (newOuterTile) return

        val nextSqueeze = squeeze.continueSqueeze(pipeMaze) ?: return



        connectSqueezePipes(nextSqueeze)

    }

}