package problems.day16.cells

import problems.day16.BeamDirection

// Symbol: .
class EmptyMirrorCell : MirrorCellType() {
    companion object {
        private var instance: MirrorCellType? = null

        fun getInstance(): MirrorCellType {
            if (instance == null) {
                instance = EmptyMirrorCell()
            }
            return instance!!
        }
    }

    override fun reflectDirection(dir: BeamDirection): List<BeamDirection> {
        return listOf(dir)
    }

}