package problems.day20

abstract class Module(val resultMods: List<String>, val name: String) {

    var lastSignal: Signal = Signal.LOW

    fun receiveSignal(signal: Signal): Signal? {
        val nextSignal = innerHandleSignal(signal)
        if (nextSignal != null) {
            lastSignal = nextSignal
        }
        return nextSignal
    }

    abstract fun innerHandleSignal(signal: Signal): Signal?

}