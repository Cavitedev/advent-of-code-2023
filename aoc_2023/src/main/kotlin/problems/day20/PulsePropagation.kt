package problems.day20

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
                module = Broadcaster(values)
            } else if (line.startsWith("%")) {
                module = FlipFlopModule(values)
                name = name.substring(1)
            } else if (line.startsWith("&")) {
                module = ConjuctionModule(values)
                name = name.substring(1)
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
        val res = PulseResult(0L, 0L, modules)

        for (i in 1..n) {
            val intermidiateRes = pulseButton()
            res.addResult(intermidiateRes)
        }

        return res
    }

    fun pulseButton(): PulseResult {
        val res = PulseResult(0L, 0L, modules)

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
                pendingProcesses.add(PulseProccess(resMod, nextSignal))
            }

        }

        return res

    }


}