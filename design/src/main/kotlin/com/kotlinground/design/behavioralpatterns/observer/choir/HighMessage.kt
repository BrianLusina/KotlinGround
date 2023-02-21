package com.kotlinground.design.behavioralpatterns.observer.choir

data class HighMessage(override val repeat: Times) : Message {
    override val pitch = SoundPitch.HIGH
}
