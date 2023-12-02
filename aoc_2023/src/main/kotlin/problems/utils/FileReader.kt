package problems.utils

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun readInput(name: String) = Path("src/test/resources/problems/$name.txt").readLines()