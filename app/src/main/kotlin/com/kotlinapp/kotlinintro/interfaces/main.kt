package com.kotlinapp.kotlinintro.interfaces

/**
 * @author lusinabrian on 07/12/17.
 */
fun main(args: Array<String>) {
    val car = Car()

    car.playRadio()

    println("Seat color ${car.seatColor}")
    car.changeSeatColor("blue")
    println("Seat color ${car.seatColor}")
}