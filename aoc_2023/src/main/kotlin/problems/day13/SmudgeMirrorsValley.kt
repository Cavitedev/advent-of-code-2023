package problems.day13

class SmudgeMirrorsValley(input: List<String>) : MirrorsValley(input) {

    override fun getMirrorsPatterns(): List<MirrorsPattern> {
        return super.getMirrorsPatterns().map { SmudgeMirrorsPattern(it) }
    }

}