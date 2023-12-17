package problems.day17

class CrucibleCity(lines: List<String>) {

    val grid: List<List<Int>> = lines.map { line -> line.map { char -> char.digitToInt() } }

    fun minimumHeastLoss(): Int {
        val search = CrucibleSearch(this)
        return search.minimumHeastLoss()
    }

}