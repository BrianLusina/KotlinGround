package com.kotlinground.design.behavioralpatterns.observer.choir

interface Message {
    val repeat: Times
    val pitch: SoundPitch
}
