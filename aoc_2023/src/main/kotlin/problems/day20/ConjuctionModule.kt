package problems.day20

class ConjuctionModule(result: List<String>, name: String) : Module(result, name) {

    var dependantModules: MutableList<Module> = mutableListOf()

    override fun innerHandleSignal(signal: Signal): Signal {
        val allHigh = dependantModules.all { it.lastSignal == Signal.HIGH }
        return if (allHigh) Signal.LOW else Signal.HIGH
    }
}