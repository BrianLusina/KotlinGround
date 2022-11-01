package com.kotlinground.design.creationalpatterns.factory.gui.win

import com.kotlinground.design.creationalpatterns.factory.gui.Checkbox

class WinCheckBox: Checkbox {
    override fun paint() {
        println("Win Checkbox")
    }
}
