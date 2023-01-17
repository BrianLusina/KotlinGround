package com.kotlinground.design.behavioralpatterns.mediator.gui.mediator

import com.kotlinground.design.behavioralpatterns.mediator.gui.components.Component
import com.kotlinground.design.behavioralpatterns.mediator.gui.components.List
import javax.swing.ListModel

interface Mediator {
    fun addNewNote(note: Note)
    fun deleteNote()
    fun getInfoFromList(note: Note)
    fun saveChanges()
    fun markNote()
    fun clear()
    fun sendToFilter(listModel: ListModel<Note>)
    fun setElementsList(list: ListModel<Note>)
    fun registerComponent(component: Component)
    fun hideElements(flag: Boolean)
    fun createGUI()
}