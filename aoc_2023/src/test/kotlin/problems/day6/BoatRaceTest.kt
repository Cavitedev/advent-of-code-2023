package problems.day6

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BoatRaceTest {

    @Test
    fun waysOfBeatingRecord() {
        val race = BoatRace(7, 9)
        assertEquals(4, race.waysOfBeatingRecord())
    }

    @Test
    fun waysOfBeatingRecord2() {
        val race = BoatRace(30, 200)
        assertEquals(9, race.waysOfBeatingRecord())
    }
}