package problems.day20

data class PulseResult(var lowPulses: Long, var highPulses: Long, var state: Map<String, Module>) {

    var pressesRx = false

    fun addResult(other: PulseResult) {
        this.lowPulses += other.lowPulses
        this.highPulses += other.highPulses
    }

}