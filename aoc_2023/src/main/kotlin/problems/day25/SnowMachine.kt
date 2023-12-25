package problems.day25

class SnowMachine(input: List<String>) {

    val components = mutableMapOf<String, Component>()
    val pairs = (mutableSetOf<ComponentPair>())

    init {

        for (line in input) {
            val (componentStr, connected) = line.split(":")
            val connectedComponentsStr = connected.split(" ").map { it.trim() }.filter { it.isNotBlank() }

            var firstComponent: Component? = components[componentStr]
            val otherComponents = mutableListOf<Component>()

            if (firstComponent == null) {
                firstComponent = Component(componentStr)
                components[componentStr] = firstComponent
            }
            for (connectedStr in connectedComponentsStr) {
                var otherComponent = components[connectedStr]
                if (otherComponent == null) {
                    otherComponent = Component(connectedStr)
                    components[connectedStr] = otherComponent
                }
                pairs.add(ComponentPair(firstComponent, otherComponent))
                otherComponents.add(otherComponent)
                otherComponent.otherComponents.add(firstComponent)
            }

            firstComponent.otherComponents.addAll(otherComponents)


        }

    }


    fun groupDividerProduct(): Int {
        val groups = GroupDividider(this, 3).divideIn2Groups()
        return groups.fold(1) { acc, group ->
            acc * group.size
        }
    }


}