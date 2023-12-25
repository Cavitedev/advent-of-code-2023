package problems.day25

class Component(val name: String) {
    val otherComponents = mutableSetOf<Component>()
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Component) return false

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    override fun toString(): String {
        return "Component(name='$name')"
    }


}