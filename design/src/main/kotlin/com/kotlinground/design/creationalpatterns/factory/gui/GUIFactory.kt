package com.kotlinground.design.creationalpatterns.factory.gui

/**
 * Abstract Factory
 */
interface GUIFactory {
    fun createButton(): Button
    fun createCheckBox(): Checkbox
}
