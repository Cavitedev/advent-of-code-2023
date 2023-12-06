package problems.day6

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import problems.utils.readInput

class BoatRacesTest {

    @Nested
    inner class Part1 {
        lateinit var boatRaces: BoatRaces

        @BeforeEach
        fun setUp() {
            boatRaces = BoatRaces.fromLines(readInput("day6/input_test"))
        }

        @Test
        fun getRaces() {
            assertEquals(3, boatRaces.races.count())
            assertEquals(listOf(BoatRace(7, 9), BoatRace(15, 40), BoatRace(30, 200)), boatRaces.races)
        }

        @Test
        fun waysOfBeatingRecordsProduct() {
            assertEquals(288, boatRaces.waysOfBeatingRecordsProduct())
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun waysToBeatRecord() {
            val boatRaces = BoatRaces.fromRightKerningLines(readInput("day6/input_test"))
            assertEquals(71503, boatRaces.waysOfBeatingRecordsProduct())
        }
    }


}