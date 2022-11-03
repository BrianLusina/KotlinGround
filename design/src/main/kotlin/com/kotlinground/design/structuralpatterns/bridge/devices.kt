package com.kotlinground.design.structuralpatterns.bridge

interface Device {
    fun isEnabled(): Boolean
    fun enable()
    fun disable()
    fun getVolume(): Long
    fun setVolume(level: Long)
    fun getChannel(): Int
    fun setChannel(channel: Int)
}

open class Remote(private val device: Device) {
    fun togglePower() {
        if (device.isEnabled()) {
            device.disable()
        } else {
            device.enable()
        }
    }

    fun volumeUp() {
        val previousVolume = device.getVolume()
        device.setVolume(previousVolume + 1)
    }

    fun volumeDown() {
        val previousVolume = device.getVolume()
        device.setVolume(previousVolume - 1)
    }

    fun channelUp() {
        val previousChannel = device.getChannel()
        device.setChannel(previousChannel + 1)
    }

    fun channelDown() {
        val previousChannel = device.getChannel()
        device.setChannel(previousChannel - 1)
    }
}

class AdvancedRemote(private val device: Device) : Remote(device) {
    fun mute() {
        device.setVolume(0)
    }
}

class Radio : Device {
    override fun isEnabled(): Boolean {
        TODO("Not yet implemented")
    }

    override fun enable() {
        TODO("Not yet implemented")
    }

    override fun disable() {
        TODO("Not yet implemented")
    }

    override fun getVolume(): Long {
        TODO("Not yet implemented")
    }

    override fun setVolume(level: Long) {
        TODO("Not yet implemented")
    }

    override fun getChannel(): Int {
        TODO("Not yet implemented")
    }

    override fun setChannel(channel: Int) {
        TODO("Not yet implemented")
    }
}

class TV : Device {
    override fun isEnabled(): Boolean {
        TODO("Not yet implemented")
    }

    override fun enable() {
        TODO("Not yet implemented")
    }

    override fun disable() {
        TODO("Not yet implemented")
    }

    override fun getVolume(): Long {
        TODO("Not yet implemented")
    }

    override fun setVolume(level: Long) {
        TODO("Not yet implemented")
    }

    override fun getChannel(): Int {
        TODO("Not yet implemented")
    }

    override fun setChannel(channel: Int) {
        TODO("Not yet implemented")
    }
}

fun main() {
    val tv = TV()
    val tvRemote = Remote(tv)
    val advancedTvRemote = AdvancedRemote(tv)

    val radio = Radio()
    val radioRemote = Remote(radio)
    val advancedRadioRemote = AdvancedRemote(radio)
}