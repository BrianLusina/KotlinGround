package com.kotlinground.design.creationalpatterns.factory.gui.win

import com.kotlinground.design.creationalpatterns.factory.gui.Button

class WinButton: Button {
    override fun paint() {
        println("Win Button")
    }
}
