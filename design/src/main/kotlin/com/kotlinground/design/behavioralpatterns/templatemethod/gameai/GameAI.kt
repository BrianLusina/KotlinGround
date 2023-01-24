package com.kotlinground.design.behavioralpatterns.templatemethod.gameai

/**
 * The abstract class defines a template method that contains a skeleton of some algorithm composed of calls, usually to
 * abstract primitive operations. Concrete subclasses implement these operations, but leave the template method itself
 * intact.
 */
abstract class GameAI {

    // The template method defines the skeleton of an algorithm.
    fun turn() {
        collectResources()
        buildStructures()
        buildUnits()
        attack()
    }

    // Some the steps may be implemented right in a base
    // class
    open fun collectResources() {
//        this.builtStructures.forEach {
//            it.collect()
//        }
    }

    abstract fun buildStructures()
    abstract fun buildUnits()

    fun attack() {
//        val enemy = clossestEnemy()
//        if (enemy != null) {
//            sendScouts(map.center)
//        } else {
//            sendWarriors(enemy.position)
//        }
    }

    abstract fun sendScouts(position: Long)

    abstract fun sendWarriors(position: Long)
}
