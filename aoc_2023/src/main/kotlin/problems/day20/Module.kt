package problems.day20

abstract class Module(val resultMods: List<String>, val name: String) {

    var lastSignal: Signal = Signal.LOW
    val sentSignalsRound: MutableList<Signal> = mutableListOf()

    fun receiveSignal(signal: Signal): Signal? {
        val nextSignal = innerHandleSignal(signal)
        if (nextSignal != null) {
            lastSignal = nextSignal
            sentSignalsRound.add(nextSignal)
        }
        return nextSignal
    }

    abstract fun innerHandleSignal(signal: Signal): Signal?

}