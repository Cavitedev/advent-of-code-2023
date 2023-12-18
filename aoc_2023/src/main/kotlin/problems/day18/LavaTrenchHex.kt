package problems.day18

import problems.utils.Utils

class LavaTrenchHex(lines: List<String>) : LavaTrench(lines.map { line ->
    val color = line.split(" ")[2]
    val hexColor = Utils.colorStrInLineStr(color)!!
    val steps = hexColor.substring(0, hexColor.length - 1)
    val stepsAmount = steps.toInt(16)
    val dirChar = hexColor.last()
    val dir = when (dirChar) {
        '0' -> {
            'R'
        }

        '1' -> {
            'D'
        }

        '2' -> {
            'L'
        }

        '3' -> {
            'U'
        }

        else -> {
            'R'
        }
    }

    "$dir $stepsAmount"
})