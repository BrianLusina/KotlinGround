package com.kotlinground.design.behavioralpatterns.mediator.gui.components

import com.kotlinground.design.behavioralpatterns.mediator.gui.mediator.Mediator
import com.kotlinground.design.behavioralpatterns.mediator.gui.mediator.Note
import java.awt.event.ActionEvent
import javax.swing.JButton

class AddButton(override val mediator: Mediator) : JButton(), Component {
    override val name: String
        get() = "Add"

    override fun fireActionPerformed(event: ActionEvent?) {
        mediator.addNewNote(Note(g))
    }
}
