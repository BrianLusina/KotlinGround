package com.kotlinground.design.structuralpatterns.composite

interface Trooper {
    fun move(x: Long, y: Long)
    fun attackRebel(x: Long, y: Long)
}

typealias PointsOfDamage = Long
typealias Meters = Double

val RIFLE_DAMAGE = 3L
val REGULAR_SPEED: Meters = 1.0

interface Weapon {
    fun attack(): PointsOfDamage
}

class Rifle : Weapon {
    override fun attack(): PointsOfDamage = RIFLE_DAMAGE
}

class FlameThrower : Weapon {
    override fun attack(): PointsOfDamage = RIFLE_DAMAGE * 2
}

class Batton : Weapon {
    override fun attack(): PointsOfDamage = RIFLE_DAMAGE * 3
}

interface Legs {
    fun move(): Meters
}

class RegularLegs : Legs {
    override fun move(): Meters = REGULAR_SPEED
}

class AthleticLegs : Legs {
    override fun move(): Meters = REGULAR_SPEED * 2
}

data class StormTrooper(private val weapon: Weapon, private val legs: Legs) : Trooper {
    override fun move(x: Long, y: Long) {
        legs.move()
    }

    override fun attackRebel(x: Long, y: Long) {
        weapon.attack()
    }
}

open class Squad(private val units: List<Trooper>) : Trooper {
    constructor(vararg units: Trooper) : this(units.toList())

    override fun move(x: Long, y: Long) {
        for (u in units) {
            u.move(x, y)
        }
    }

    override fun attackRebel(x: Long, y: Long) {
        units.forEach { it.attackRebel(x, y) }
    }
}

fun main() {

    val stormTrooper = StormTrooper(Rifle(), RegularLegs())
    val flameTrooper = StormTrooper(FlameThrower(), RegularLegs())
    val scoutTrooper = StormTrooper(Rifle(), AthleticLegs())

    val squadOne = Squad(scoutTrooper, stormTrooper, flameTrooper)
    val squadTwo = Squad(scoutTrooper, stormTrooper, flameTrooper)
    val platoon = Squad(squadOne, squadTwo)

    squadOne.move(1, 2)
    squadTwo.attackRebel(3, 4)

    platoon.move(1, 2)
    platoon.attackRebel(4, 5)
}
