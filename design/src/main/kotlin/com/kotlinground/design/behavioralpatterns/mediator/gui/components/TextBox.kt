package com.kotlinground.design.behavioralpatterns.mediator.gui.components

import com.kotlinground.design.behavioralpatterns.mediator.gui.mediator.Mediator
import java.awt.event.KeyEvent
import javax.swing.JTextArea

class TextBox(override val mediator: Mediator) : JTextArea(), Component {
    override val name: String
        get() = "TextBox"

    override fun processComponentKeyEvent(e: KeyEvent?) {
        mediator.markNote()
    }
}