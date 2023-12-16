package problems.day16.cells

import problems.day16.*

// Symbol: \
class BackwardSlashMirrorCell : MirrorCellType() {

    companion object {
        private var instance: MirrorCellType? = null

        fun getInstance(): MirrorCellType {
            if (instance == null) {
                instance = BackwardSlashMirrorCell()
            }
            return instance!!
        }
    }

    override fun reflectDirection(dir: BeamDirection): List<BeamDirection> {
        return listOf(
            when (dir.beamType()) {
                'W' -> {
                    NorthBeamDir.getInstance()
                }

                'N' -> {
                    WestBeamDir.getInstance()
                }

                'E' -> {
                    SouthBeamDir.getInstance()
                }

                'S' -> {
                    EastBeamDir.getInstance()
                }


                else -> {
                    throw Exception("Invalid dir")
                }
            }
        )
    }


}