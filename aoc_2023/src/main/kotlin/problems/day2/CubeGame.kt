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

    fun minimumSet(): CubeRound {
        return this.rounds.reduce { val1, val2 ->
            val1.combineMinimumSet(val2)
        }
    }

}