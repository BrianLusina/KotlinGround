package com.kotlinground.design.behavioralpatterns.iterator

import com.kotlinground.design.structuralpatterns.composite.RegularLegs
import com.kotlinground.design.structuralpatterns.composite.Rifle
import com.kotlinground.design.structuralpatterns.composite.Squad
import com.kotlinground.design.structuralpatterns.composite.StormTrooper
import com.kotlinground.design.structuralpatterns.composite.Trooper


class TroopIterator(private val units: List<Trooper>) : Iterator<Trooper> {
    private var i = 0
    private var iterator: Iterator<Trooper> = this

    override fun hasNext(): Boolean {
        if (i >= units.size) {
            return false
        }
        if (i == units.size - 1) {
            if (iterator != this) {
                return iterator.hasNext()
            }
        }
        return true
    }

    override fun next(): Trooper {
        if (iterator != this) {
            if (iterator.hasNext()) {
                return iterator.next()
            } else {
                i++
                iterator = this
            }
        }
        return when (val e = units[i]) {
            is MySquad -> {
                iterator = e.iterator()
                this.next()
            }

            else -> {
                i++
                e
            }
        }
    }
}

class MySquad(private val units: List<Trooper>) : Squad(units) {
    constructor(vararg units: Trooper) : this(units.toList())

    operator fun iterator(): Iterator<Trooper> {
        return TroopIterator(units)
    }
}

fun main() {
    val platoon = MySquad(
        StormTrooper(
            Rifle(),
            RegularLegs()
        ),
        StormTrooper(
            Rifle(),
            RegularLegs()
        ),
        Squad(
            StormTrooper(
                Rifle(),
                RegularLegs()
            ),
            StormTrooper(
                Rifle(),
                RegularLegs()
            ),
        ),
        StormTrooper(
            Rifle(),
            RegularLegs()
        )
    )

    for (trooper in platoon) {
        println(trooper)
    }
}