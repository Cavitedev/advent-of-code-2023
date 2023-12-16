package problems.day16.cells

import problems.day16.BeamDirection
import problems.day16.NorthBeamDir
import problems.day16.SouthBeamDir

// Symbol: |
class VerticalSplitterCell : MirrorCellType() {
    companion object {
        private var instance: MirrorCellType? = null

        fun getInstance(): MirrorCellType {
            if (instance == null) {
                instance = VerticalSplitterCell()
            }
            return instance!!
        }
    }

    override fun reflectDirection(dir: BeamDirection): List<BeamDirection> {
        if (dir.isHorizontal()) return listOf(NorthBeamDir.getInstance(), SouthBeamDir.getInstance())
        return listOf(dir)
    }
}