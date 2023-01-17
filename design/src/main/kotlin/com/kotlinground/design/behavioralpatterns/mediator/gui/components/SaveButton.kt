package com.kotlinground.design.behavioralpatterns.mediator.gui.components

import com.kotlinground.design.behavioralpatterns.mediator.gui.mediator.Mediator
import java.awt.event.ActionEvent
import javax.swing.JButton

class SaveButton(override val mediator: Mediator): JButton(), Component {
    override val name: String
        get() = "SaveButton"

    override fun fireActionPerformed(event: ActionEvent?) {
        mediator.saveChanges()
    }
}
