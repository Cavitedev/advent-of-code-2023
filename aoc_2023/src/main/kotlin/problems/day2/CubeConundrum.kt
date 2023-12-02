package problems.day2

class CubeConundrum(val games: List<CubeGame>) {

    companion object {

        fun fromLines(input: List<String>): CubeConundrum {
            val mutableListGames: MutableList<CubeGame> = mutableListOf()
            for (line in input) {
                val (gameStr, contentStr) = line.split(":")
                val gameId = gameStr.split(" ")[1].toInt()

                val gamesStr = contentStr.split(";")
                val rounds: MutableList<CubeRound> = mutableListOf()

                for (gameSplit in gamesStr) {
                    val spaceSplit = gameSplit.replace(",", "").split(" ")

                    val cubes = mutableMapOf(
                        "red" to 0,
                        "green" to 0,
                        "blue" to 0
                    )

                    for (i in spaceSplit.indices) {
                        val el = spaceSplit[i]
                        if (cubes.containsKey(el)) {
                            cubes[el] = spaceSplit[i - 1].toInt()
                        }
                    }
                    val cubeRound = CubeRound(cubes["red"]!!, cubes["green"]!!, cubes["blue"]!!)
                    rounds.add(cubeRound)
                }

                val game = CubeGame(gameId, rounds)
                mutableListGames.add(game)
            }
            return CubeConundrum(mutableListGames)
        }
    }

    fun sumIdPossibleGames(maxRound: CubeRound): Int {
        return this.games.fold(0) { acc, game ->
            val isPossible = game.isPossibleGame(maxRound)
            acc + if (isPossible) game.id else 0
        }
    }

    fun sumPowersMinimumSets(): Int {
        return this.games.fold(0) { acc, it ->
            acc + it.minimumSet().powerSet()
        }
    }

}