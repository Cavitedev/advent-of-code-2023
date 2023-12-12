package problems.day12


data class HotSpringLine(val springs: String, val conditionRecords: List<Int>) {

    fun arrangementsCount(): Long {
        if (springs == "") {
            if (conditionRecords.isEmpty()) return 1L
            return 0L
        }
        if (springs.startsWith(".")) {
            val firstElementNotDot = springs.indexOfAny(charArrayOf('#', '?'), 0, false)
            val subtring = if (firstElementNotDot == -1) "" else springs.substring(firstElementNotDot)
            return HotSpringLine(subtring, conditionRecords).arrangementsCount()
        }

        var arrangements = 0L

        var index = 0
        val dotIndex = springs.indexOf(".")

        val nextSprings = if (dotIndex == -1) "" else springs.substring(dotIndex + 1)

        val backtrackingValues = if (dotIndex == -1) MutableList(springs.count()) { 0 } else MutableList(dotIndex) { 0 }


        var currentGroupCount = 0
        var recordIndex = 0

        val afterDotResults = mutableMapOf<Int, Long>()

        // # only checks # and backtracking
        for (i in backtrackingValues.indices) {
            val letter = springs[i]
            if (letter == '#') {
                backtrackingValues[i] = 1
            }
        }

        val lastGroupCount = MutableList(backtrackingValues.count()) { 0 }

        while (true) {

            backtrackingValues[index] += 1
            val value = backtrackingValues[index]


            // .
            if (value == 1) {
                if (springs[index] == '#') continue

                lastGroupCount[index] = currentGroupCount
                val pair = groupStop(currentGroupCount, recordIndex) ?: continue
                recordIndex = pair.first
                currentGroupCount = pair.second
            } else if (value == 2) {
                lastGroupCount[index] = currentGroupCount
                currentGroupCount += 1
            }

            // Backtracking
            else if (value == 3) {
                if (index == 0)
                    break

                if (index > 1 && backtrackingValues[index - 2] == 2 && backtrackingValues[index - 1] == 1) {
                    recordIndex--
                    currentGroupCount = lastGroupCount[index - 1]
                } else {
                    currentGroupCount = lastGroupCount[index]
                }
                backtrackingValues[index] = 0


                index--
                continue
            }

            if (index == backtrackingValues.size - 1) {
                val pair = groupStop(currentGroupCount, recordIndex) ?: continue
                val nextCurrentCondition = pair.first

                var calculatedValue = afterDotResults[nextCurrentCondition]
                if (calculatedValue == null) {
                    calculatedValue =
                        HotSpringLine(nextSprings, conditionRecords.drop(nextCurrentCondition)).arrangementsCount()
                    afterDotResults[nextCurrentCondition] = calculatedValue
                }
                arrangements += calculatedValue

                if (value == 1) {
                    if (lastGroupCount[index] > 0) {
                        recordIndex--
                    }
                    currentGroupCount = lastGroupCount[index]
                }

                continue
            }



            index++


        }

        return arrangements

    }

    private fun groupStop(
        currentGroupCount: Int,
        recordIndex: Int,
    ): Pair<Int, Int>? {
        var currentGroupCount1 = currentGroupCount
        var recordIndex1 = recordIndex
        if (currentGroupCount1 > 0) {
            if (conditionRecords.size > recordIndex1 && conditionRecords[recordIndex1] == currentGroupCount1) {
                currentGroupCount1 = 0
                recordIndex1++
            } else {
                return null
            }
        }
        return Pair(recordIndex1, currentGroupCount1)
    }


}