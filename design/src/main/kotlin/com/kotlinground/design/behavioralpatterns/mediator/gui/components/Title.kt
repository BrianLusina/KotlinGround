package com.kotlinground.design.behavioralpatterns.mediator.gui.components

import com.kotlinground.design.behavioralpatterns.mediator.gui.mediator.Mediator
import java.awt.event.KeyEvent
import javax.swing.JTextField

class Title(override val mediator: Mediator): JTextField(), Component {
    override val name: String
        get() = "Title"

    override fun processComponentKeyEvent(e: KeyEvent?) {
        mediator.markNote()
    }
}