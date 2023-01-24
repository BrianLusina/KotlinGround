package com.kotlinground.design.behavioralpatterns.templatemethod.gameai

// Subclasses can also override some operations with a default
// implementation.
class MonstersAI: GameAI() {
    override fun collectResources() {}

    override fun buildStructures() {
        TODO("Not yet implemented")
    }

    override fun buildUnits() {
        TODO("Not yet implemented")
    }

    override fun sendScouts(position: Long) {
        TODO("Not yet implemented")
    }

    override fun sendWarriors(position: Long) {
        TODO("Not yet implemented")
    }
}