package problems.day20

class Broadcaster(result: List<String>) : Module(result) {
    override fun innerHandleSignal(signal: Signal): Signal {
        return signal
    }
}