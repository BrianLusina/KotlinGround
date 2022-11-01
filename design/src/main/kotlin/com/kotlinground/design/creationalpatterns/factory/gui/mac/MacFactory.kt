package com.kotlinground.design.creationalpatterns.factory.gui.mac

import com.kotlinground.design.creationalpatterns.factory.gui.Button
import com.kotlinground.design.creationalpatterns.factory.gui.Checkbox
import com.kotlinground.design.creationalpatterns.factory.gui.GUIFactory

class MacFactory : GUIFactory {
    override fun createButton(): Button {
        return MacButton()
    }

    override fun createCheckBox(): Checkbox {
        return MacCheckBox()
    }
}
