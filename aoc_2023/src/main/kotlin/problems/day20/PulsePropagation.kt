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
                if (resMod == "rx" && nextSignal == Signal.LOW) {
                    res.pressesRx = true
                }
                pendingProcesses.add(PulseProccess(resMod, nextSignal))
            }

        }

        return res

    }

    fun countUntilRx(): Long {
        val flipFlopsRequired = flipFlopPulseRequired()

        val rightModsLists: List<RepeatAmounts> = flipFlopsRequired.map { RepeatAmounts(mutableListOf()) }
        val boolPatterns: List<MutableList<Boolean>> = flipFlopsRequired.map { mutableListOf() }

        var n = 20000L

        for (i in 1..<n) {
            pulseButton()
            val rightMods = flipFlopsRequired.map {
                val mod = this.modules[it.name]!!
                val isRight = mod.lastSignal == it.signal
                isRight
            }
            rightMods.forEachIndexed { index, it ->
                rightModsLists[index].add(it)
                boolPatterns[index].add(it)
            }


//            res.addResult(intermidiateRes)
        }
//        println(rightModsLists.map {
//            it.map {
//                val res = if (it) "Y" else "N"
//                res
//            }
//        }
//        )

        val pulsePatterns = rightModsLists.map { resFlipFlops ->
            resFlipFlops.toPattern()
//            val firstFalse =
//            val firstTrueAfterFalse = resFlipFlops.subList(firstFalse, resFlipFlops.size).indexOf(true) + firstFalse
//            val firstFalseAfterTrue = resFlipFlops.subList(firstTrueAfterFalse, resFlipFlops.size).indexOf(false) + firstTrueAfterFalse
//            PulsePattern(firstTrueAfterFalse, firstFalseAfterTrue - firstTrueAfterFalse)
        }

        val reducedPulsePatterns = pulsePatterns.toSet()

        val reducedPattern = reducedPulsePatterns.sortedBy { it.size }.reduce { a, b ->
            a.combine(b)
        }

        while (true) {
            var allTrue = reducedPulsePatterns.map { it.isValid(n) }
            n++
            if (allTrue.all { it }) {
                break
            }
        }

        return 0L
    }

    fun flipFlopPulseRequired(): List<PulseProccess> {

        val rxResult = this.modules.values.find { it.resultMods.contains("rx") }!!

        return flipFlopsFromResult(rxResult, Signal.LOW)

    }

    fun flipFlopsFromResult(module: Module, signalRequired: Signal): List<PulseProccess> {
        if (module is FlipFlopModule) {
            return listOf(PulseProccess(module.name, signalRequired))
        } else if (module is ConjuctionModule) {
            val dependencies = module.dependantModules
            val invSignal = when (signalRequired) {
                Signal.HIGH -> Signal.LOW
                Signal.LOW -> Signal.HIGH
            }
            val dep = dependencies.map { flipFlopsFromResult(it, invSignal) }.flatten()
            return dep
        }

        throw Exception("Unreachable")
    }


}