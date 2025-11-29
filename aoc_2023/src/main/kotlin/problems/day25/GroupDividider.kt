package problems.day25

class GroupDividider(val snowMachine: SnowMachine, val disconnectWires: Int) {


    fun divideIn2Groups(): List<Set<Component>> {

        val group1 = mutableSetOf<Component>()
        val group2 = mutableSetOf<Component>()

        val visitedPairs = mutableSetOf<ComponentPair>()
        val visitedComponents = mutableSetOf<Component>()

        val refComponent = snowMachine.components.values.first()
//        val openedComponents = mutableListOf(refComponent)
        group1.add(refComponent)

        for(connectedComponent in snowMachine.components.values.drop(1)){
            if (group1.contains(connectedComponent) || group2.contains(connectedComponent)) continue
            val visitedCount = djistraIndirectReturn(connectedComponent, refComponent).size
            if (visitedCount > disconnectWires) {
                group1.add(connectedComponent)
            } else {
                group2.add(connectedComponent)
            }
        }

//        while (openedComponents.isNotEmpty()) {
//            val component = openedComponents.removeLast()
//            if (visitedComponents.contains(component)) continue
//            visitedComponents.add(component)
//
//
//            for (connectedComponent in component.otherComponents) {
//                if (group1.contains(connectedComponent) || group2.contains(connectedComponent)) continue
//
//                val pair = ComponentPair(component, connectedComponent)
//                if (visitedPairs.contains(pair)) continue
//                visitedPairs.add(pair)
//                val visitedCount = djistraIndirectReturn(connectedComponent, component)
//                if (visitedCount > disconnectWires) {
//                    group1.add(connectedComponent)
//                    openedComponents.add(connectedComponent)
//                } else {
//                    group2.add(connectedComponent)
//                }
//            }
//        }

        val group2ByDifference = this.snowMachine.components.values - group1
        return listOf(group1, group2ByDifference.toSet())
    }

    fun djistraIndirectReturn(from: Component, to: Component): List<ComponentNode> {

//        val visitedComponents = mutableSetOf<Component>()
        val visitedPairs = mutableSetOf<ComponentPair>()
        val openedNodes = mutableListOf(ComponentNode(from, null))
        val solutions = mutableListOf<ComponentNode>()


        while (openedNodes.isNotEmpty()) {
            val componentNode = openedNodes.removeFirst()

            val component = componentNode.component
            val newSolPairs = componentNode.pairs()
            if (solutions.any { it.pairs().intersect(newSolPairs).isNotEmpty() }) {
                val removePairs = newSolPairs - solutions.map { it.pairs() }.flatten()
                visitedPairs.removeAll(removePairs)
                continue
            }
            if (component == to) {
                solutions.add(componentNode)
                continue
            }

            for (connectedComponent in component.otherComponents) {
                val pair = ComponentPair(component, connectedComponent)

//                if(newSolPairs.contains(pair)) continue

                if (visitedPairs.contains(pair)) continue
//                if (visitedComponents.contains(connectedComponent)) continue
                visitedPairs.add(pair)
//                visitedComponents.add(connectedComponent)
                openedNodes.add(ComponentNode(connectedComponent, componentNode))
            }
        }

        return solutions
    }


}