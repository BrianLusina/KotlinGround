package com.kotlinground.kotlinintro.interfaces

/**
 * @author lusinabrian on 07/12/17.
 */
interface CarInterface {

    var seatColor : String

    fun playRadio(){
        println("Playing Radio")
    }

    fun changeSeatColor(newColor : String){
        seatColor = newColor
        println("Changing seat color from $seatColor to $newColor")
    }

}