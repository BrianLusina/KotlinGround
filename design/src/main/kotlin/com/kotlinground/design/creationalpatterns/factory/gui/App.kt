package com.kotlinground.design.creationalpatterns.factory.gui

import com.kotlinground.design.creationalpatterns.factory.gui.mac.MacFactory
import com.kotlinground.design.creationalpatterns.factory.gui.win.WinFactory
import java.util.*

class App(val factory: GUIFactory) {
    private val button: Button = factory.createButton()
    private val checkbox: Checkbox = factory.createCheckBox()

    fun paintButton() {
        button.paint()
    }

    fun paintCheckbox() {
        button.paint()
    }
}

data class Config(val os: String)

fun readAppConfig(): Config {
    val os = System.getProperty("os.name")
    return Config(os.lowercase(Locale.getDefault()))
}

fun main() {
    val config = readAppConfig()
    val factory = if (config.os.contains("windows")) {
        WinFactory()
    } else if (config.os.contains("mac")) {
        MacFactory()
    } else {
        throw Exception("Unknown OS ${config.os}")
    }

    val app = App(factory)
    app.paintButton()
    app.paintCheckbox()
}
