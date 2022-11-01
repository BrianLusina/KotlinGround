package com.kotlinground.design.creationalpatterns.factory.gui.mac

import com.kotlinground.design.creationalpatterns.factory.gui.Checkbox

class MacCheckBox: Checkbox {
    override fun paint() {
        println("Mac Checkbox")
    }
}
