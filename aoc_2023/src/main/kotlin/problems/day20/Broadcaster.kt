package problems.day20

class Broadcaster(result: List<String>, name: String) : Module(result, name) {
    override fun innerHandleSignal(signal: Signal): Signal {
        return signal
    }
}