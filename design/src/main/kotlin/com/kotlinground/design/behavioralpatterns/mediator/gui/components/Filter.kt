package com.kotlinground.design.behavioralpatterns.mediator.gui.components

import com.kotlinground.design.behavioralpatterns.mediator.gui.mediator.Mediator
import com.kotlinground.design.behavioralpatterns.mediator.gui.mediator.Note
import java.awt.event.KeyEvent
import javax.swing.DefaultListModel
import javax.swing.JTextField
import javax.swing.ListModel

class Filter(override val mediator: Mediator) : JTextField(), Component {
    private lateinit var listModel: ListModel<Note>

    override val name: String
        get() = "Filter"

    override fun processComponentKeyEvent(e: KeyEvent?) {
        searchElements(text)
    }

    private fun searchElements(s: String) {
        if (s.isBlank()) {
            mediator.setElementsList(listModel)
            return
        }

        val notes = arrayListOf<Note>()
        for (i in 0 until listModel.size) {
            notes.add(listModel.getElementAt(i) as Note)
        }

        listModel = DefaultListModel<Note>()
        for (note in notes) {
            if (note.name.contains(s)) {
                (listModel as DefaultListModel<Note>).addElement(note)
            }
        }

        mediator.setElementsList(listModel)
    }
}