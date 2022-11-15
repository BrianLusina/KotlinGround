package com.kotlinground.design.behavioralpatterns.strategy

interface Weapon {
    fun shoot(point: Point, direction: Direction): Projectile
}

// of using an object to act as a namespace that holds functions which return our projectiles. This reduces the number
// of classes
object Weapons {
    fun peashooter(point: Point, direction: Direction): Projectile {
        return Projectile(point, direction)
    }

    fun banana(point: Point, direction: Direction): Projectile {
        return Projectile(point, direction)
    }

    fun pomegranete(point: Point, direction: Direction): Projectile {
        return Projectile(point, direction)
    }
}

class Peashooter : Weapon {
    override fun shoot(point: Point, direction: Direction): Projectile {
        return Projectile(point, direction)
    }
}

class Banana : Weapon {
    override fun shoot(point: Point, direction: Direction): Projectile {
        return Projectile(point, direction)
    }
}

class Pomegranate : Weapon {
    override fun shoot(point: Point, direction: Direction): Projectile {
        return Projectile(point, direction)
    }
}

enum class Direction {
    LEFT, RIGHT
}

data class Point(val x: Int, val y: Int)

data class Projectile(val point: Point, val direction: Direction)

class Hero {
    private var direction = Direction.LEFT
    private var point = Point(42, 173)
    private var currentWeapon: Weapon = Peashooter()
    fun shoot(): Projectile {
        return Projectile(point, direction)
    }

    fun equip(weapon: Weapon) {
        currentWeapon = weapon
    }
}

class OurHero {
    private var direction = Direction.LEFT
    private var point = Point(42, 173)
    var currentWeapon = Weapons::peashooter
    val shoot = fun() {
        currentWeapon(point, direction)
    }
}


fun main() {
    val hero = Hero()
    hero.shoot()
    val banana = Banana()
    hero.equip(banana)
    hero.shoot()

    //using function reference operator
    val ourHero = OurHero()
    ourHero.shoot()
    ourHero.currentWeapon = Weapons::banana
    ourHero.shoot()
}