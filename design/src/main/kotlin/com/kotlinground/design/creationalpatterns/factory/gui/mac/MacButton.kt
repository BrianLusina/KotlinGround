package com.kotlinground.design.creationalpatterns.factory.gui.mac

import com.kotlinground.design.creationalpatterns.factory.gui.Button

class MacButton: Button {
    override fun paint() {
        println("Mac Button")
    }
}
