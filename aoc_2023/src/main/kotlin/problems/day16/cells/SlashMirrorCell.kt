package problems.day16.cells

import problems.day16.*

// Symbol: /
class SlashMirrorCell : MirrorCellType() {
    companion object {
        private var instance: MirrorCellType? = null

        fun getInstance(): MirrorCellType {
            if (instance == null) {
                instance = SlashMirrorCell()
            }
            return instance!!
        }
    }

    override fun reflectDirection(dir: BeamDirection): List<BeamDirection> {
        return listOf(
            when (dir.beamType()) {


                'W' -> {
                    SouthBeamDir.getInstance()
                }

                'N' -> {
                    EastBeamDir.getInstance()
                }

                'E' -> {
                    NorthBeamDir.getInstance()
                }

                'S' -> {
                    WestBeamDir.getInstance()
                }

                else -> {
                    throw Exception("Invalid dir")
                }
            }
        )
    }


}