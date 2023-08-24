package com.kotlinground.design.oop.interfaces

class SamsungRemote : Remote {
    private var currentChannel = 0

    override fun scroll() {
        println("Scrolling on $currentChannel")
    }

    override fun click() {
        println("Clicked within current channel $currentChannel")
    }

    override fun changeChannel(channelNumber: Int) {
        println("Channel changing to $channelNumber from $currentChannel")
        currentChannel = channelNumber
        println("Channel changed to $currentChannel")
    }
}
