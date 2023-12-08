package problems.day8

class DesertMap(val directions: List<Int>, val connections: Map<String, Pair<String, String>>) {


    companion object {
        val inputRegex = Regex("""(.*) = \((.*), (.*)\)""")
    }

    constructor(lines: List<String>) : this(lines[0].map {
        when (it) {
            'L' -> 0
            'R' -> 1
            else -> 2
        }
    }, lines.drop(2).map {
        val valuesRegex = inputRegex.findAll(it).first().groupValues
        valuesRegex[1] to Pair(valuesRegex[2], valuesRegex[3])
    }.toMap())


    fun stepsSolution(): Int {
        var steps = 0
        var state = "AAA"
        while (state != "ZZZ") {
            val stepVal = this.directions[steps % this.directions.count()]
            steps++
            state = this.connections[state]!!.toList()[stepVal]


        }
        return steps

    }

    fun ghostSolutions(state: String): List<GhostMapSolution> {

        val solutions: MutableList<GhostMapSolution> = mutableListOf()

        var initialStep = 0
        var initialState = state
        var steps = 0
        var currentState = state
        while (true) {
            val stepVal = this.directions[steps % this.directions.count()]
            currentState = this.connections[currentState]!!.toList()[stepVal]
            steps++
            if (currentState.last() == 'Z') {
                val sol = GhostMapSolution(initialState, initialStep, currentState, steps)
                solutions.add(sol)
                initialState = currentState
                initialStep = steps
                if (solutions.any { it.startSite == currentState }) break
            }
        }


        return solutions
    }

    fun ghostStepsSolution(): Int {
        var steps = 0
        var states = this.connections.keys.filter { it.last() == 'A' }

        while (states.any { it.last() != 'Z' }) {
            val stepVal = this.directions[steps % this.directions.count()]
            states = states.map { state ->
                this.connections[state]!!.toList()[stepVal]
            }
            steps++
        }
        return steps
    }

}