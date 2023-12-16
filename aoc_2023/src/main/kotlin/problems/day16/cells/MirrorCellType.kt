package problems.day16.cells

import problems.day16.BeamDirection

abstract class MirrorCellType {

    companion object {
        fun fromChar(char: Char): MirrorCellType {
            return when (char) {
                '.' -> {
                    EmptyMirrorCell.getInstance()
                }

                '/' -> {
                    SlashMirrorCell.getInstance()
                }

                '\\' -> {
                    BackwardSlashMirrorCell.getInstance()
                }

                '|' -> {
                    VerticalSplitterCell.getInstance()
                }

                '-' -> {
                    HorizontalSplitterMirrorCell.getInstance()
                }

                else -> {
                    EmptyMirrorCell.getInstance()
                }
            }
        }
    }

    abstract fun reflectDirection(dir: BeamDirection): List<BeamDirection>

}