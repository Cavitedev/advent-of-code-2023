package problems.day16.cells

import problems.day16.BeamDirection
import problems.day16.EastBeamDir
import problems.day16.WestBeamDir

// Symbol: -
class HorizontalSplitterMirrorCell : MirrorCellType() {
    companion object {
        private var instance: MirrorCellType? = null

        fun getInstance(): MirrorCellType {
            if (instance == null) {
                instance = HorizontalSplitterMirrorCell()
            }
            return instance!!
        }
    }

    override fun reflectDirection(dir: BeamDirection): List<BeamDirection> {
        if (dir.isVertical()) return listOf(WestBeamDir.getInstance(), EastBeamDir.getInstance())
        return listOf(dir)
    }
}