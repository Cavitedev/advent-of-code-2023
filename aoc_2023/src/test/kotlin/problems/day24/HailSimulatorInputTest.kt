package problems.day24

import org.junit.jupiter.api.BeforeEach
import problems.utils.readInput

class HailSimulatorInputTest {

    lateinit var hailSimulator: HailSimulator

    @BeforeEach
    fun setUp() {
        hailSimulator = HailSimulator(readInput("day24/input"))
    }


}