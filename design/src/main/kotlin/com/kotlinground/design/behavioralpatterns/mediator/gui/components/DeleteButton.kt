package com.kotlinground.design.behavioralpatterns.mediator.gui.components

import com.kotlinground.design.behavioralpatterns.mediator.gui.mediator.Mediator
import java.awt.event.ActionEvent
import javax.swing.JButton

class DeleteButton(override val mediator: Mediator) : JButton(), Component {
    override val name: String
        get() = "Del"

    override fun fireActionPerformed(event: ActionEvent?) {
        mediator.deleteNote()
    }
}
