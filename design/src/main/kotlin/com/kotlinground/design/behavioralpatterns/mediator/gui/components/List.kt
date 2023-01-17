package com.kotlinground.design.behavioralpatterns.mediator.gui.components

import com.kotlinground.design.behavioralpatterns.mediator.gui.mediator.Mediator
import com.kotlinground.design.behavioralpatterns.mediator.gui.mediator.Note
import javax.swing.DefaultListModel
import javax.swing.JList

class List(override val mediator: Mediator, private val listModel: DefaultListModel<Note>) : JList<Note>(listModel),
    Component {
    init {
        layoutOrientation = VERTICAL
        val thread = Thread(Hide())
        thread.start()
    }

    override val name: String
        get() = "List"

    fun addElement(note: Note) {
        listModel.addElement(note)
        val index = listModel.size() - 1
        selectedIndex = index
        ensureIndexIsVisible(index)
        mediator.sendToFilter(listModel)
    }

    fun deleteElement() {
        val index = selectedIndex
        try {
            listModel.remove(index)
            mediator.sendToFilter(listModel)
        } catch (ignored: ArrayIndexOutOfBoundsException) {
        }
    }

    fun getCurrentElement(): Note {
        return selectedValue
    }

    inner class Hide() : Runnable {
        override fun run() {
            while (true) {
                try {
                    Thread.sleep(300)
                } catch (ex: InterruptedException) {
                    ex.printStackTrace()
                }
                if (this@List.isSelectionEmpty) {
                    mediator.hideElements(true)
                } else {
                    mediator.hideElements(false)
                }
            }
        }
    }
}