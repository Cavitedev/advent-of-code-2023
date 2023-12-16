package problems.day16

data class BeamNode(val i: Int, val j: Int, val dir: BeamDirection) {

    var lastNodes: Set<BeamNode> = mutableSetOf()

    fun appendNode(beamNode: BeamNode) {
        this.lastNodes = beamNode.lastNodes.plus(beamNode)
    }

    fun isRepeated(): Boolean {
        return this.lastNodes.contains(this)
    }

    fun nextNodes(cave: MirrorCave): List<BeamNode> {
        if (isRepeated()) return listOf()
        val nextPos = dir.nextPos(i, j, cave.grid) ?: return listOf()
        val nextDirs = cave.grid[nextPos.first][nextPos.second].reflectDirection(dir)

        return nextDirs.map {
            val node = BeamNode(nextPos.first, nextPos.second, it)
            node.appendNode(this)
            node
        }

    }
}