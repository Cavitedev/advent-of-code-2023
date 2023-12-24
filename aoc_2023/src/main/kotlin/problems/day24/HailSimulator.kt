package problems.day24

import com.microsoft.z3.Context
import com.microsoft.z3.Status
import java.math.BigDecimal
import java.math.MathContext

class HailSimulator(lines: List<String>) {

    val hailstones = lines.map { line ->
        val (cord, mov) = line.split("@").map {
            val splits = it.split(",").map { splittedCoord ->
                splittedCoord.trim().toBigDecimal(MathContext(20))
            }
            HailCoordinate(splits[0], splits[1], splits[2])
        }
        Hailstone(cord, mov)
    }

    fun intersectionsXY(): List<HailCoordinate> {
        val returnIntersections = mutableListOf<HailCoordinate>()

        for (i in 0..<this.hailstones.size) {
            for (j in i + 1..<this.hailstones.size) {
                val intersection = this.hailstones[i].intersectionXY(this.hailstones[j]) ?: continue
                returnIntersections.add(intersection)
            }
        }

        return returnIntersections

    }

    fun intersectionsIn2DArea(min: BigDecimal, max: BigDecimal): List<HailCoordinate> {
        return intersectionsXY().filter {
            it.x >= min && it.x <= max &&
                    it.y >= min && it.y <= max
        }

    }

    fun combinations(): List<Pair<Hailstone, Hailstone>> {
        val combinations = mutableListOf<Pair<Hailstone, Hailstone>>()
        for (i in 0..<this.hailstones.size) {
            for (j in i + 1..<this.hailstones.size) {
                combinations.add(Pair(hailstones[i], hailstones[j]))
            }
        }
        return combinations
    }

    fun relativePositions(): List<Int> {
        return combinations().map { it.first.relativePosition(it.second) }
    }

    fun firstPlane(): HailPlane {

        for (i in 0..<this.hailstones.size) {
            for (j in i + 1..<this.hailstones.size) {
                val plane = this.hailstones[i].planeParalelLines(this.hailstones[j]) ?: continue
                return plane
            }
        }

        throw Exception("Unreachable")

    }

    fun rockThrown(): Hailstone {
        val plane = firstPlane()
        val usedHailstones = mutableListOf<Hailstone>()
        val intersections = mutableListOf<HailCoordinate>()

        for (hailstone in hailstones) {
            try {
                val planes = hailstone.toPlanes()
                val intersection = plane.intersection(planes[0], planes[1])
                intersections.add(intersection)
                usedHailstones.add(hailstone)
            } catch (e: ArithmeticException) {

            }
            if (intersections.size >= 2) break
        }

//        val planesHailStones = this.hailstones.take(2).map { it.toPlanes() }
//        val intersections = planesHailStones.map { plane.intersection(it[0], it[1]) }
        val timeIntersection1 = (intersections[0].x - usedHailstones[0].pos.x) / usedHailstones[0].vel.x
        val timeIntersection2 = (intersections[1].x - usedHailstones[1].pos.x) / usedHailstones[1].vel.x
        return rockFromTimesAndIntersections(listOf(timeIntersection1, timeIntersection2), intersections)

    }

    private fun rockFromTimesAndIntersections(
        usedTimes: List<BigDecimal>,
        intersections: List<HailCoordinate>,
    ): Hailstone {
        val timeIntersection1 = usedTimes[0]
        val timeIntersection2 = usedTimes[1]

        if (timeIntersection1 < timeIntersection2) {
            return rockFromIntersectionsAndTime(intersections[0], intersections[1], timeIntersection1)
        } else {
            return rockFromIntersectionsAndTime(intersections[1], intersections[0], timeIntersection1)
        }
    }

    private fun rockFromIntersectionsAndTime(
        firstIntersection: HailCoordinate,
        secondIntersection: HailCoordinate,
        timeIntersection1: BigDecimal
    ): Hailstone {
        val speed = secondIntersection.subtract(firstIntersection)
        val startPos = secondIntersection.subtract(speed.multiply(timeIntersection1))
        return Hailstone(startPos, speed)
    }

    fun rockThrownBruteForcing(): Hailstone? {

        for (x in -400..400) {
            for (y in -400..400) {
                for (z in -400..400) {
                    val adjustedSpeed = HailCoordinate(x.toBigDecimal(), y.toBigDecimal(), z.toBigDecimal())
                    val adjustedHailstones = hailstones.map {
                        Hailstone(it.pos, it.vel.subtract(adjustedSpeed))
                    }

                    val refHailstone = adjustedHailstones.first()
                    var intersect = refHailstone.intersectionXYZ(adjustedHailstones[1])
                    var index = 2
                    while (intersect != null) {
                        if (index >= adjustedHailstones.size) {
                            val timeIntersection1 =
                                (intersect.x - adjustedHailstones[0].pos.x) / adjustedHailstones[0].vel.x
                            val timeIntersection2 =
                                (intersect.x - adjustedHailstones[1].pos.x) / adjustedHailstones[1].vel.x

                            val timeIntersections = listOf(timeIntersection1, timeIntersection2)

                            val intersections = this.hailstones.take(2).mapIndexed { index, hailstone ->
                                hailstone.pos.add(hailstone.vel.multiply(timeIntersections[index]))
                            }
                            print("SOL")

                            val orderedIntersections = timeIntersections.zip(intersections).sortedBy { it.first }
                            val vel =
                                (orderedIntersections[1].second.subtract(orderedIntersections[0].second)).divide(
                                    orderedIntersections[1].first - orderedIntersections[0].first
                                )

                            val position =
                                orderedIntersections[0].second.subtract(vel.multiply(orderedIntersections[0].first))

                            return Hailstone(position, vel)
                            // solution
                        }
                        val nextHailstone = adjustedHailstones[index]
                        val newIntersect = refHailstone.intersectionXYZ(nextHailstone)
                        if (newIntersect != intersect) break
                        index++
                    }
                }
            }
        }
        return null

    }


    fun resolveEquations(): Hailstone? {
        val ctx = Context()
        val t1 = ctx.mkRealConst("t1")
        val t2 = ctx.mkRealConst("t2")
        val t3 = ctx.mkRealConst("t3")
        val x = ctx.mkRealConst("x")
        val vx = ctx.mkRealConst("vx")
        val y = ctx.mkRealConst("y")
        val vy = ctx.mkRealConst("vy")
        val z = ctx.mkRealConst("z")
        val vz = ctx.mkRealConst("vz")

        val hailstone1 = this.hailstones[0]
        val hailstone2 = this.hailstones[1]
        val hailstone3 = this.hailstones[2]

        val el1_x = ctx.mkReal(hailstone1.pos.x.toPlainString())
        val el1_vx = ctx.mkReal(hailstone1.vel.x.toPlainString())
        val el2_x = ctx.mkReal(hailstone2.pos.x.toPlainString())
        val el2_vx = ctx.mkReal(hailstone2.vel.x.toPlainString())
        val el3_x = ctx.mkReal(hailstone3.pos.x.toPlainString())
        val el3_vx = ctx.mkReal(hailstone3.vel.x.toPlainString())

        val el1_y = ctx.mkReal(hailstone1.pos.y.toPlainString())
        val el1_vy = ctx.mkReal(hailstone1.vel.y.toPlainString())
        val el2_y = ctx.mkReal(hailstone2.pos.y.toPlainString())
        val el2_vy = ctx.mkReal(hailstone2.vel.y.toPlainString())
        val el3_y = ctx.mkReal(hailstone3.pos.y.toPlainString())
        val el3_vy = ctx.mkReal(hailstone3.vel.y.toPlainString())

        val el1_z = ctx.mkReal(hailstone1.pos.z.toPlainString())
        val el1_vz = ctx.mkReal(hailstone1.vel.z.toPlainString())
        val el2_z = ctx.mkReal(hailstone2.pos.z.toPlainString())
        val el2_vz = ctx.mkReal(hailstone2.vel.z.toPlainString())
        val el3_z = ctx.mkReal(hailstone3.pos.z.toPlainString())
        val el3_vz = ctx.mkReal(hailstone3.vel.z.toPlainString())

        val eq1 = ctx.mkEq(
            ctx.mkSub(el1_x, ctx.mkMul(el1_vx, t1)),
            ctx.mkAdd(x, ctx.mkMul(vx, t1))
        )
        val eq2 = ctx.mkEq(
            ctx.mkSub(el2_x, ctx.mkMul(el2_vx, t2)),
            ctx.mkAdd(x, ctx.mkMul(vx, t2))
        )
        val eq3 = ctx.mkEq(
            ctx.mkSub(el3_x, ctx.mkMul(el3_vx, t3)),
            ctx.mkAdd(x, ctx.mkMul(vx, t3))
        )
        val eq4 = ctx.mkEq(
            ctx.mkSub(el1_y, ctx.mkMul(el1_vy, t1)),
            ctx.mkAdd(y, ctx.mkMul(vy, t1))
        )

        val eq5 = ctx.mkEq(
            ctx.mkSub(el2_y, ctx.mkMul(el2_vy, t2)),
            ctx.mkAdd(y, ctx.mkMul(vy, t2))
        )

        val eq6 = ctx.mkEq(
            ctx.mkSub(el3_y, ctx.mkMul(el3_vy, t3)),
            ctx.mkAdd(y, ctx.mkMul(vy, t3))
        )
        val eq7 = ctx.mkEq(
            ctx.mkSub(el1_z, ctx.mkMul(el1_vz, t1)),
            ctx.mkAdd(z, ctx.mkMul(vz, t1))
        )
        val eq8 = ctx.mkEq(
            ctx.mkSub(el2_z, ctx.mkMul(el2_vz, t2)),
            ctx.mkAdd(z, ctx.mkMul(vz, t2))
        )

        val eq9 = ctx.mkEq(
            ctx.mkSub(el3_z, ctx.mkMul(el3_vz, t3)),
            ctx.mkAdd(z, ctx.mkMul(vz, t3))
        )

        val solver = ctx.mkSolver()

        // Add equations to the solver
        solver.add(eq1)
        solver.add(eq2)
        solver.add(eq3)
        solver.add(eq4)
        solver.add(eq5)
        solver.add(eq6)
        solver.add(eq7)
        solver.add(eq8)
        solver.add(eq9)

        val result = solver.check()

        if (result == Status.SATISFIABLE) {
            // Get the model
            val model = solver.model

            // Get parameter values from the model
            val xValue = model.eval(x, false).toString()
            val yValue = model.eval(y, false).toString()
            val zValue = model.eval(z, false).toString()
            val vxValue = model.eval(vx, false).toString()
            val vyValue = model.eval(vy, false).toString()
            val vzValue = model.eval(vz, false).toString()

            // Print parameter values
//            println("x = $xValue")
//            println("y = $yValue")
//            println("z = $zValue")
//            println("vx = $vxValue")
//            println("vy = $vyValue")
//            println("vz = $vzValue")

            return Hailstone(
                HailCoordinate(BigDecimal(xValue), BigDecimal(yValue), BigDecimal(zValue)),
                HailCoordinate(BigDecimal(vxValue), BigDecimal(vyValue), BigDecimal(vzValue))
            )
        } else {
            println("No solution found.")
            return null
        }
    }

}