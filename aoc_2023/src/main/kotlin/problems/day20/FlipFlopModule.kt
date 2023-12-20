package problems.day20

class FlipFlopModule(result: List<String>, name: String) : Module(result, name) {

    var isOn: Boolean = false


    override fun innerHandleSignal(signal: Signal): Signal? {
        if (signal == Signal.HIGH) return null
        isOn = !isOn
        return if (isOn) Signal.HIGH else Signal.LOW
    }
}