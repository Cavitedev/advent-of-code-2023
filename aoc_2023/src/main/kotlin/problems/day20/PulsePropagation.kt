package problems.day20

import problems.utils.Utils

class PulsePropagation(lines: List<String>) {

    val modules: Map<String, Module>

    companion object {
        val broadcasterName = "broadcaster"
    }

    init {
        modules = lines.map { line ->

            val targetStr = line.split("->")[1]
            val values = targetStr.trim().split(", ")

            lateinit var module: Module
            var name: String = line.takeWhile { it != ' ' }
            if (line.startsWith(broadcasterName)) {
                module = Broadcaster(values, name)
            } else if (line.startsWith("%")) {
                name = name.substring(1)
                module = FlipFlopModule(values, name)
            } else if (line.startsWith("&")) {
                name = name.substring(1)
                module = ConjuctionModule(values, name)
            }

            return@map name to module
        }.toMap()

        val conjuctionModules = modules.filter { it.value is ConjuctionModule }

        modules.forEach { entry ->
            val results = entry.value.resultMods.toSet()
            results.forEach { result ->
                val conjMod = conjuctionModules[result]
                if (conjMod != null) {
                    (conjMod as ConjuctionModule).dependantModules.add(entry.value)
                }
            }
        }

    }

    fun pulseButton(n: Long): PulseResult {
        val res = PulseResult(0L, 0L)

        for (i in 1..n) {
            val intermidiateRes = pulseButton()
            res.addResult(intermidiateRes)
        }

        return res
    }

    fun pulseButton(): PulseResult {
        this.modules.forEach { it.value.sentSignalsRound.clear() }
        val res = PulseResult(0L, 0L)

        // Button first
        val pendingProcesses = mutableListOf(PulseProccess(broadcasterName, Signal.LOW))

        while (pendingProcesses.isNotEmpty()) {
            val nextProcess = pendingProcesses.removeAt(0)
            when (nextProcess.signal) {
                Signal.HIGH -> res.highPulses++
                Signal.LOW -> res.lowPulses++
            }
            val module = this.modules[nextProcess.name] ?: continue
            val nextSignal = module.receiveSignal(nextProcess.signal) ?: continue



            for (resMod in module.resultMods) {
                if (resMod == "rx" && nextSignal == Signal.LOW) {
                    res.pressesRx = true
                }
                pendingProcesses.add(PulseProccess(resMod, nextSignal))
            }

        }

        return res

    }

    fun countUntilRx(): Long {
        var n = 0L

        val rxBefore: ConjuctionModule = this.modules.values.find { it.resultMods.contains("rx") } as ConjuctionModule
        val connectedRx = rxBefore.dependantModules


        val repeatValues: MutableList<Long> = connectedRx.map { -1L }.toMutableList()
        var remainingModsToCalc = connectedRx.size

        while (remainingModsToCalc > 0) {
            n++
            pulseButton()
            connectedRx.forEachIndexed { index, module ->
                val isRight = module.sentSignalsRound.contains(Signal.HIGH)
                if (isRight) {
                    val prevRepeatValue = repeatValues[index]
                    if (prevRepeatValue == -1L) {
                        repeatValues[index] = n
                        remainingModsToCalc--
                    }
                }
            }
        }

        // listOf(3767, 3779, 4057, 3889)
        return Utils.calculateLCM(repeatValues)
    }


}