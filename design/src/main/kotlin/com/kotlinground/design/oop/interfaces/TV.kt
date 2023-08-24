package com.kotlinground.design.oop.interfaces

class TV(private val remote: Remote) {
    private var currentChannel: Int = 0

    fun changeChannel() {

        remote.changeChannel(2)
    }

    companion object {
        fun spawn() {
            println("Spawning New TV")
        }
    }
}
