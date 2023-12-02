package problems.day2

class CubeGame(id: Int, rounds: List<CubeRound>) {

    val id: Int
    val rounds: List<CubeRound>

    init {
        this.id = id
        this.rounds = rounds
    }

    fun isPossibleGame(maxRound: CubeRound): Boolean {
        return this.rounds.all {
            it.possibleRound(maxRound)
        }
    }

}