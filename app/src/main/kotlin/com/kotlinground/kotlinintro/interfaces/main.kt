package com.kotlinground.kotlinintro.interfaces

/**
 * @author lusinabrian on 07/12/17.
 */
fun main() {
    val car = Car()

    car.playRadio()

    println("Seat color ${car.seatColor}")
    car.changeSeatColor("blue")
    println("Seat color ${car.seatColor}")
}