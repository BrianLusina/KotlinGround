package com.kotlinground.design.creationalpatterns.factory.gui.win

import com.kotlinground.design.creationalpatterns.factory.gui.Button
import com.kotlinground.design.creationalpatterns.factory.gui.Checkbox
import com.kotlinground.design.creationalpatterns.factory.gui.GUIFactory

class WinFactory: GUIFactory {
    override fun createButton(): Button {
        return WinButton()
    }

    override fun createCheckBox(): Checkbox {
        return WinCheckBox()
    }
}
