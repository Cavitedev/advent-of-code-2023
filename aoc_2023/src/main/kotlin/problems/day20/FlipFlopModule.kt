package problems.day20

class FlipFlopModule(result: List<String>) : Module(result) {

    var isOn: Boolean = false


    override fun innerHandleSignal(signal: Signal): Signal? {
        if (signal == Signal.HIGH) return null
        isOn = !isOn
        return if (isOn) Signal.HIGH else Signal.LOW
    }
}