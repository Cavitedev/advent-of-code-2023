package problems.day25

class ComponentNode(val component: Component, val lastNode: ComponentNode?) {

    fun pairs(): List<ComponentPair> {
        val returnList = mutableListOf<ComponentPair>()
        var thisNode = this
        while (thisNode.lastNode != null) {
            returnList.add(ComponentPair(thisNode.component, thisNode.lastNode!!.component))
            thisNode = thisNode.lastNode!!
        }
        return returnList
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ComponentNode) return false

        if (component != other.component) return false

        return true
    }

    override fun hashCode(): Int {
        return component.hashCode()
    }

    override fun toString(): String {
        return "ComponentNode(component=$component)"
    }


}