package problems.day25

data class ComponentPair(val component1: Component, val component2: Component) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ComponentPair) return false

        if (component1 != other.component1 && component1 != other.component2) return false
        if (component2 != other.component2 && component2 != other.component1) return false

        return true
    }

    override fun hashCode(): Int {
        var result = component1.hashCode() + component2.hashCode()
        return result
    }
}