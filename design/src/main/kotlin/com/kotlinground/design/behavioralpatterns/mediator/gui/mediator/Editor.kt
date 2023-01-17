package com.kotlinground.design.behavioralpatterns.mediator.gui.mediator

import com.kotlinground.design.behavioralpatterns.mediator.gui.components.AddButton
import com.kotlinground.design.behavioralpatterns.mediator.gui.components.Component
import com.kotlinground.design.behavioralpatterns.mediator.gui.components.DeleteButton
import com.kotlinground.design.behavioralpatterns.mediator.gui.components.Filter
import com.kotlinground.design.behavioralpatterns.mediator.gui.components.SaveButton
import com.kotlinground.design.behavioralpatterns.mediator.gui.components.TextBox
import com.kotlinground.design.behavioralpatterns.mediator.gui.components.Title
import javax.swing.JLabel
import javax.swing.ListModel
import com.kotlinground.design.behavioralpatterns.mediator.gui.components.List as MyList


class Editor : Mediator {
    private lateinit var title: Title
    private lateinit var textBox: TextBox
    private lateinit var add: AddButton
    private lateinit var del: DeleteButton
    private lateinit var save: SaveButton
    private lateinit var myList: MyList
    private lateinit var filter: Filter

    private val titleLabel: JLabel = JLabel("Title:")
    private val textLabel: JLabel = JLabel("Text:")
    private val label: JLabel = JLabel("Add or select existing note to proceed...")

    override fun addNewNote(note: Note) {
        title.text = ""
        textBox.text = ""
        myList.addElement(note)
    }

    override fun deleteNote() {
        myList.deleteElement()
    }

    override fun getInfoFromList(note: Note) {
        title.text = note.name.replace("*", " ")
        textBox.text = note.text
    }

    override fun saveChanges() {
        try {
            val note = myList.selectedValue as Note
            note.copy(name = title.text, text = textBox.text)
            myList.repaint()
        } catch (ignored: NullPointerException) {
        }
    }

    override fun markNote() {
        try {
            val note = myList.getCurrentElement()
            val name = note.name
            if (!name.endsWith("*")) {
                note.copy(name = note.name + "*")
            }
            myList.repaint()
        } catch (ignore: NullPointerException) {
        }
    }

    override fun clear() {
        title.text = ""
        textBox.text = ""
    }

    override fun sendToFilter(listModel: ListModel<Note>) {
        filter.setList(listModel)
    }

    override fun setElementsList(list: ListModel<Note>) {
        myList.model = list
        myList.repaint()
    }

    override fun registerComponent(component: Component) {
        when (component.name) {
            "AddButton" -> add = AddButton(this)
            "DelButton" -> del = DeleteButton(this)
            "Filter" -> filter = Filter(this)
            "List" -> {
                myList = MyList(this)
                myList.addListSelectionListener { _ ->
                    val note =
                        myList.selectedValue
                    if (note != null) {
                        getInfoFromList(note)
                    } else {
                        clear()
                    }
                }
            }

            "SaveButton" -> save = SaveButton(this)
            "TextBox" -> textBox = TextBox(this)
            "Title" -> title = Title(this)
        }
    }

    override fun hideElements(flag: Boolean) {
        titleLabel.isVisible = !flag
        textLabel.isVisible = !flag
        title.isVisible = !flag
        textBox.isVisible = !flag
        save.isVisible = !flag
        label.isVisible = flag
    }

    override fun createGUI() {
        TODO("Not yet implemented")
    }
}