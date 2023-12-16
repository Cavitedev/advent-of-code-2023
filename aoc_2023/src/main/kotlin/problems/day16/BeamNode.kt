package problems.day16

data class BeamNode(val i: Int, val j: Int, val dir: BeamDirection) {



    fun nextNodes(cave: MirrorCave): List<BeamNode> {
        val nextPos = dir.nextPos(i, j, cave.grid) ?: return listOf()
        val nextDirs = cave.grid[nextPos.first][nextPos.second].reflectDirection(dir)

        return nextDirs.map {
            val node = BeamNode(nextPos.first, nextPos.second, it)
            node
        }

    }
}