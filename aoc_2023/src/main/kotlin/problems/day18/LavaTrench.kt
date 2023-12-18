package problems.day18

import problems.utils.Utils

class LavaTrench(lines: List<String>) {

    val digList: List<DigData> = lines.map { line ->
        val (dir, amount, color) = line.split(" ")
        val hexColor = Utils.colorStrInLineStr(color)!!
        DigData(
            when (dir) {
                "R" -> {
                    EastTrenchDir.getInstance()
                }

                "D" -> {
                    SouthTrenchDir.getInstance()
                }

                "L" -> {
                    WestTrenchDir.getInstance()
                }

                "U" -> {
                    NorthTrenchDir.getInstance()
                }

                else -> {
                    NorthTrenchDir.getInstance()
                }
            },
            amount.toInt(),
            hexColor.toInt(16)

        )
    }

    var cells: MutableSet<LavaCell> = mutableSetOf()

    fun setTrenchCells() {
        var i = 0
        var j = 0

        for (dig in digList) {
            for (step in 1..dig.amount) {
                val currentCell = dig.direction.nextPos(i, j)
                i = currentCell.first
                j = currentCell.second
                cells.add(LavaCell(i, j, dig.color))
            }
        }
    }

    fun fillWithEmptyCells() {
        val firstCellPair = digList[0].direction.nextPos(0, 0)
        val firstInnerCellPair = digList.last().direction.nextPos(firstCellPair.first, firstCellPair.second)
        val firstInnerCell = LavaCell(firstInnerCellPair.first, firstInnerCellPair.second, 0)


        val openedCells = mutableListOf(firstInnerCell)

        while (openedCells.isNotEmpty()) {
            val openedCell = openedCells.removeAt(0)
            val neighbours = neighbours(openedCell.i, openedCell.j)
            for (neighbour in neighbours) {
                val neighbourCell = LavaCell(neighbour.first, neighbour.second, 0)
                if (cells.contains(neighbourCell))
                    continue
                openedCells.add(neighbourCell)
                cells.add(neighbourCell)

            }

        }


    }

    fun neighbours(i: Int, j: Int): List<Pair<Int, Int>> {
        return listOf(
            WestTrenchDir.getInstance().nextPos(i, j),
            NorthTrenchDir.getInstance().nextPos(i, j),
            EastTrenchDir.getInstance().nextPos(i, j),
            SouthTrenchDir.getInstance().nextPos(i, j)
        )
    }
}