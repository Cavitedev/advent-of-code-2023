package problems.day12

data class HotSpringLine(var springs: String, var conditionRecords: List<Int>) {

    data class Iteration(val groups: Int, val amount: Int)

    fun arrangementsCount(): Long {

        var iterations: Map<Iteration, Long> = mapOf(Pair(Iteration(0, 0), 1))

        for (char in springs) {
            val newIterations: MutableMap<Iteration, Long> = mutableMapOf()

            for (iteration in iterations) {
                val it = iteration.key


                val nextGroup = conditionRecords.getOrNull(it.groups)

                if (char == '.' || char == '?') {
                    if (nextGroup == null || nextGroup <= it.amount || it.amount == 0) {

                        val nextIteration = if (it.amount > 0) it.copy(amount = 0, groups = it.groups + 1) else it
                        newIterations[nextIteration] = (newIterations[nextIteration] ?: 0) + iteration.value

                    }

                }

                if (char == '#' || char == '?') {
                    if (nextGroup != null && it.amount < nextGroup) {
                        val nextIteration = it.copy(amount = it.amount + 1)
                        newIterations[nextIteration] = (newIterations[nextIteration] ?: 0L) + iteration.value
                    }

                }


            }

            iterations = newIterations.toMap()
        }

        val itGroups = Iteration(groups = this.conditionRecords.size, amount = 0)
        val itMissingGroup = Iteration(
            groups = this.conditionRecords.size - 1,
            amount = this.conditionRecords[this.conditionRecords.size - 1]
        )

        return (iterations[itGroups] ?: 0L) + (iterations[itMissingGroup] ?: 0L)
    }

//    fun arrangementsCount(repeatIndex: Int = springs.length / 5): Long {
//        if (springs == "") {
//            if (conditionRecords.isEmpty()) return 1L
//            return 0L
//        }
//        if (springs.startsWith(".")) {
//            val firstElementNotDot = springs.indexOfAny(charArrayOf('#', '?'), 0, false)
//            val subtring = if (firstElementNotDot == -1) "" else springs.substring(firstElementNotDot)
//            return HotSpringLine(subtring, conditionRecords).arrangementsCount(repeatIndex)
//        }
//
//
//        var arrangements = 0L
//
//        var index = 0
//        val dotIndex = springs.indexOf(".")
//
//        val nextSprings = if (dotIndex == -1) "" else springs.substring(dotIndex + 1)
//
//        val backtrackingValues = if (dotIndex == -1) MutableList(springs.count()) { 0 } else MutableList(dotIndex) { 0 }
//
//
//        var currentGroupCount = 0
//        var recordIndex = 0
//
//        val afterDotResults = mutableMapOf<Int, Long>()
//        val intermediateSolutionsMap = mutableMapOf<Int, MutableMap<Int, Long>>()
//
//
//        val lastGroupCount = MutableList(backtrackingValues.count()) { 0 }
//
//        while (true) {
//
//            backtrackingValues[index] += 1
//            var value = backtrackingValues[index]
//
//            // .
//            if (value == 1) {
//                if (springs[index] == '#') continue
//
//
//                val pair = groupStop(currentGroupCount, recordIndex) ?: continue
//                lastGroupCount[index] = currentGroupCount
//                recordIndex = pair.first
//                currentGroupCount = pair.second
//
//                if (index == recordIndex) {
//                    var intermediateSolutions = intermediateSolutionsMap[index]
//                    if (intermediateSolutions == null) {
//                        intermediateSolutionsMap[index] = mutableMapOf()
//                        intermediateSolutions = mutableMapOf()
//                    }
//                    var intermediateSolution = intermediateSolutions[recordIndex]
//                    if (intermediateSolution == null) {
//                        intermediateSolution = HotSpringLine(
//                            this.springs.substring(index + 1), conditionRecords.drop(recordIndex)
//                        ).arrangementsCount(repeatIndex)
//                        intermediateSolutions[recordIndex] = intermediateSolution
//                    }
//                    arrangements += intermediateSolution
//
//                    if (lastGroupCount[index] > 0) {
//                        recordIndex--
//                    }
//                    currentGroupCount = lastGroupCount[index]
//                    continue
//                }
//
//
//            }
//            if (value == 2) {
//                lastGroupCount[index] = currentGroupCount
//                currentGroupCount += 1
//            }
//
//            // Backtracking
//            else if (value == 3) {
//                if (index == 0) break
//
//                if (index > 1 && backtrackingValues[index - 2] == 2 && backtrackingValues[index - 1] == 1) {
//                    recordIndex--
//                    currentGroupCount = lastGroupCount[index - 1]
//                } else {
//                    currentGroupCount = lastGroupCount[index]
//                }
//                backtrackingValues[index] = 0
//
//
//                index--
//                continue
//            }
//
//            if (index == backtrackingValues.size - 1) {
//                val pair = groupStop(currentGroupCount, recordIndex) ?: continue
//                val nextRecordIndex = pair.first
//
//                var calculatedValue = afterDotResults[nextRecordIndex]
//                if (calculatedValue == null) {
//                    calculatedValue = HotSpringLine(
//                        nextSprings, conditionRecords.drop(nextRecordIndex)
//                    ).arrangementsCount(repeatIndex)
//                    afterDotResults[nextRecordIndex] = calculatedValue
//                }
//                arrangements += calculatedValue
//
//                if (value == 1) {
//                    if (lastGroupCount[index] > 0) {
//                        recordIndex--
//                    }
//                    currentGroupCount = lastGroupCount[index]
//                }
//
//                continue
//            }
//
//
//
//            index++
//
//
//        }
//
//        return arrangements
//
//    }

//    private fun groupStop(
//        currentGroupCount: Int,
//        recordIndex: Int,
//    ): Pair<Int, Int>? {
//        var currentGroupCount1 = currentGroupCount
//        var recordIndex1 = recordIndex
//        if (currentGroupCount1 > 0) {
//            if (conditionRecords.size > recordIndex1 && conditionRecords[recordIndex1] == currentGroupCount1) {
//                currentGroupCount1 = 0
//                recordIndex1++
//            } else {
//                return null
//            }
//        }
//        return Pair(recordIndex1, currentGroupCount1)
//    }


    fun fold() {

        conditionRecords = List(conditionRecords.size * 5) { conditionRecords[it % conditionRecords.size] }

        val springCopy = springs
        for (i in 0..<4) {
            springs = "$springs?$springCopy"
        }
    }

//    fun arrangementsCountFolded(): Long {
//        val count1 = arrangementsCount()
//        val springCopy = springs
//        springs = "?" + springCopy
//        val count2 = arrangementsCount()
//        springs = springCopy + "?"
//        val count3 = arrangementsCount()
//
//        return count1 * count2 * count2 * count2 * count2
//    }
}