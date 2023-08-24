package com.kotlinground.design.oop.interfaces

class LGRemote : Remote {
    override fun scroll() {
        println("Scrolling")
    }

    override fun click() {
        println("Clicking")
    }

    override fun changeChannel(channelNumber: Int) {
        println("Changing channel to $channelNumber")
    }
}
