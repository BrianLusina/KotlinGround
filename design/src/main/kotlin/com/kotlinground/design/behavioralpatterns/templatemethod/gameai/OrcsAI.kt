package com.kotlinground.design.behavioralpatterns.templatemethod.gameai

// Concrete classes have to implement all abstract operations of
// the base class but, they must not override the template method
// itself.
class OrcsAI: GameAI() {
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