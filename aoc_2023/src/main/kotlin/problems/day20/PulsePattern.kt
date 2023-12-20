package problems.day20

import problems.utils.Utils

data class PulsePattern(val trueRanges: List<LongRange>, val size: Long) {

    fun isValid(n: Long): Boolean {
        return trueRanges.any { range ->
            range.contains(n % size)
        }
    }

    fun combine(other: PulsePattern): PulsePattern {
        val lcm = Utils.calculateLCM(other.size, size)
//        val combinedRanges = (other.trueRanges + trueRanges).toMutableList()

        val r1 = repeatPatterns(lcm, other, 1000)
        val r2 = repeatPatterns(lcm, this, 1000)


        val intersection = findIntersection(r2, r1)

        return PulsePattern(intersection, lcm)

    }

    private fun repeatPatterns(
        lcm: Long,
        other: PulsePattern,
        n: Int
    ): List<LongRange> {
        val combinedRanges = other.trueRanges.toMutableList()
        val gcd1 = lcm / other.size
        for (i in 1..<gcd1) {
            if (i > n) break
            for (range in other.trueRanges) {
                val offset = other.size * i
                combinedRanges.add(range.first + offset..range.last + offset)
            }
        }
        return combinedRanges
    }

//    fun findIntersectionWithIntervalTree(list1: List<LongRange>, list2: List<LongRange>): List<LongRange> {
//    val intervalTree = IntervalTree<Long, LongRange>()
//
//    list1.forEach { range ->
//        intervalTree.add(range.start, range.endInclusive, range)
//    }
//
//    val intersection = mutableListOf<LongRange>()
//
//    list2.forEach { range ->
//        intervalTree.search(range.start, range.endInclusive).forEach {
//            intersection.add(it.getValue())
//        }
//    }
//
//    return intersection
//}

    fun findIntersection(list1: List<LongRange>, list2: List<LongRange>): List<LongRange> {
        val intersection = mutableListOf<LongRange>()

        for (range1 in list1) {
            for (range2 in list2) {
                val start = maxOf(range1.first, range2.first)
                val end = minOf(range1.last, range2.last)

                if (start <= end) {
                    intersection.add(start..end)
                }
            }
        }

        return intersection
    }

    fun combineRanges(ranges: List<LongRange>): List<LongRange> {
        val sortedRanges = ranges.sortedBy { it.start }

        val result = mutableListOf<LongRange>()
        var currentRange = sortedRanges.first()

        for (range in sortedRanges.drop(1)) {
            if (currentRange.endInclusive >= range.start - 1) {
                // Ranges overlap or are adjacent, merge them
                currentRange = currentRange.start..maxOf(currentRange.endInclusive, range.endInclusive)
            } else {
                // Ranges do not overlap, add the current range to the result
                result.add(currentRange)
                currentRange = range
            }
        }

        // Add the last range
        result.add(currentRange)

        return result
    }

}

class IntervalTree<T : Comparable<T>, V>(private val root: Node<T, V>? = null) {

    data class Node<T : Comparable<T>, V>(
        val interval: ClosedRange<T>,
        val value: V,
        var maxEnd: T,
        var left: Node<T, V>? = null,
        var right: Node<T, V>? = null
    )

    fun insert(interval: ClosedRange<T>, value: V): IntervalTree<T, V> {
        val newNode = Node(interval, value, interval.endInclusive)

        return IntervalTree(insertNode(root, newNode))
    }

    private fun insertNode(current: Node<T, V>?, newNode: Node<T, V>): Node<T, V> {
        if (current == null) {
            return newNode
        }

        val cmp = newNode.interval.start.compareTo(current.interval.start)

        if (cmp < 0) {
            current.left = insertNode(current.left, newNode)
        } else {
            current.right = insertNode(current.right, newNode)
        }

        if (current.maxEnd < newNode.maxEnd) {
            current.maxEnd = newNode.maxEnd
        }

        return current
    }

    fun intersect(queryInterval: ClosedRange<T>): List<Node<T, V>> {
        val result = mutableListOf<Node<T, V>>()
        intersect(root, queryInterval, result)
        return result
    }

    private fun intersect(current: Node<T, V>?, queryInterval: ClosedRange<T>, result: MutableList<Node<T, V>>) {
        if (current == null) {
            return
        }

        if (current.left != null && current.left!!.maxEnd >= queryInterval.start) {
            intersect(current.left, queryInterval, result)
        }

        if (current.interval.endInclusive >= queryInterval.start && current.interval.start <= queryInterval.endInclusive) {
            result.add(current)
        }

        if (current.right != null && current.interval.start <= queryInterval.endInclusive) {
            intersect(current.right, queryInterval, result)
        }
    }
}