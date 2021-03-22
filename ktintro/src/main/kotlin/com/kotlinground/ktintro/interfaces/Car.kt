package com.kotlinground.kotlinintro.interfaces

/**
 * @author lusinabrian on 07/12/17.
 */
class Car : CarInterface{
    override var seatColor = "black"

    var radioStation = "RockFX"

    override fun playRadio() {
        super.playRadio()
        println("listening in on $radioStation Station")
    }

    override fun changeSeatColor(newColor: String) {
        super.changeSeatColor(newColor)
    }
}
