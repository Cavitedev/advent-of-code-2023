package problems.day17

class UltraCrucibleSearch(city: CrucibleCity) : CrucibleSearch(city) {

    override fun nextDirs(node: CrucibleNode): List<CrucibleDirection> {
        val repeatedDirs = node.repeatedDirs()
        if (repeatedDirs < 4) {
            return listOf(node.dir)
        }
        if (repeatedDirs in 4..9) {
            return listOf(node.dir, node.dir.rotateAntiClockwise(), node.dir.rotateClockwise())
        }

        return listOf(node.dir.rotateAntiClockwise(), node.dir.rotateClockwise())
    }

    override fun isGoal(node: CrucibleNode): Boolean {
        return super.isGoal(node) && node.repeatedDirs() >= 4
    }

}