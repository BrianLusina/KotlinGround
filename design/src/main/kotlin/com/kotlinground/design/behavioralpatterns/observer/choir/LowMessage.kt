package com.kotlinground.design.behavioralpatterns.observer.choir

data class LowMessage(override val repeat: Times) : Message {
    override val pitch = SoundPitch.LOW
}
