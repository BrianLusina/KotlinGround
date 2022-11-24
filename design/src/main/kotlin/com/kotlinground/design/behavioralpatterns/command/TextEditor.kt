package com.kotlinground.design.behavioralpatterns.command

import java.awt.FlowLayout
import java.util.*
import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.JTextArea
import javax.swing.WindowConstants


/**
 * Command interface declares a single method for executing the command
 */
interface Command {
    fun execute(): Boolean
}

abstract class BaseCommand(private val editor: TextEditor) : Command {
    private var backup = ""

    fun backup() {
        backup = editor.textField.text
    }

    fun undo() {
        editor.textField.text = backup
    }
}

class CopyCommand(private val editor: TextEditor) : BaseCommand(editor) {
    override fun execute(): Boolean {
        editor.clipboard = editor.textField.selectedText
        return false
    }
}

class CutCommand(private val editor: TextEditor) : BaseCommand(editor) {
    override fun execute(): Boolean {
        if (editor.textField.selectedText.isEmpty()) return false

        backup()
        val source = editor.textField.text
        editor.clipboard = editor.textField.selectedText
        editor.textField.text = cutString(source)
        return true
    }

    private fun cutString(source: String): String {
        val start = source.substring(0, editor.textField.selectionStart)
        val end = source.substring(editor.textField.selectionEnd)
        return start + end
    }
}

class PasteCommand(private val editor: TextEditor) : BaseCommand(editor) {
    override fun execute(): Boolean {
        if (editor.clipboard.isEmpty()) return false

        backup()
        editor.textField.insert(editor.clipboard, editor.textField.caretPosition)
        return true
    }
}

class CommandHistory {
    private val history = Stack<BaseCommand>()

    fun push(command: BaseCommand) {
        history.push(command)
    }

    fun pop(): BaseCommand {
        return history.pop()
    }

    fun isEmpty(): Boolean = history.isEmpty()
}

class TextEditor {
    lateinit var textField: JTextArea
    var clipboard = ""
    private val history = CommandHistory()

    fun create() {
        val frame = JFrame("TextEditor")
        val content = JPanel()
        frame.contentPane = content
        frame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        content.layout = BoxLayout(content, BoxLayout.Y_AXIS)
        textField = JTextArea()
        textField.lineWrap = true
        content.add(textField)
        val buttons = JPanel(FlowLayout(FlowLayout.CENTER))
        val ctrlC = JButton("Ctrl+C")
        val ctrlX = JButton("Ctrl+X")
        val ctrlV = JButton("Ctrl+V")
        val ctrlZ = JButton("Ctrl+Z")

        ctrlC.addActionListener {
            executeCommand(CopyCommand(this))
        }

        ctrlX.addActionListener {
            executeCommand(CutCommand(this))
        }

        ctrlV.addActionListener {
            executeCommand(PasteCommand(this))
        }

        ctrlZ.addActionListener { undo() }

        buttons.add(ctrlC)
        buttons.add(ctrlX)
        buttons.add(ctrlV)
        buttons.add(ctrlZ)
        content.add(buttons)
        frame.setSize(450, 200)
        frame.setLocationRelativeTo(null)
        frame.isVisible = true
    }

    private fun executeCommand(command: BaseCommand) {
        if (command.execute()) {
            history.push(command)
        }
    }

    private fun undo() {
        if (history.isEmpty()) return

        val command = history.pop()
        command.undo()
    }
}

fun main() {
    val editor = TextEditor()
    editor.create()
}