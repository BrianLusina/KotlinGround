package com.kotlinground.design.behavioralpatterns.state

import java.awt.FlowLayout
import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.JTextField

/**
 * Common interface for all states.
 */
sealed interface State {
    fun onLock(): String
    fun onPlay(): String
    fun onNext(): String
    fun onPrevious(): String
}

sealed class PlayerState : State

/**
 * Context passes itself through the state constructor. This may help a
 * state to fetch some useful context data if needed.
 *
 * Concrete states provide the special implementation for all interface methods.
 */
class LockedState(private val player: Player) : PlayerState() {
    override fun onLock(): String {
        if (player.isPlaying()) {
            player.state = ReadyState(player)
            return "Stop Playing"
        }
        return "Locked"
    }

    override fun onPlay(): String {
        player.state = ReadyState(player)
        return "Ready"
    }

    override fun onNext(): String {
        return "Locked"
    }

    override fun onPrevious(): String {
        return "Locked"
    }
}

class ReadyState(private val player: Player) : PlayerState() {
    override fun onLock(): String {
        player.state = LockedState(player)
        return "Locked"
    }

    override fun onPlay(): String {
        val action = player.startPlayback()
        player.state = PlayingState(player)
        return action
    }

    override fun onNext(): String {
        return "Locked"
    }

    override fun onPrevious(): String {
        return "Locked"
    }
}

class PlayingState(private val player: Player) : PlayerState() {
    override fun onLock(): String {
        player.state = LockedState(player)
        player.setCurrentTrackAfterStop()
        return "Stop Playing"
    }

    override fun onPlay(): String {
        player.state = ReadyState(player)
        return "Paused"
    }

    override fun onNext(): String {
        return player.nextTrack()
    }

    override fun onPrevious(): String {
        return player.previousTrack()
    }
}

class Player {
    internal var state: PlayerState = ReadyState(this)
    private val playlist = arrayListOf<String>()
    private var currentTrack = 0
    private var playing = false

    init {
        playing = true
        for (i in 1..12) {
            playlist.add("Track $i")
        }
    }

    fun isPlaying(): Boolean = playing

    fun startPlayback(): String = "Playing ${playlist[currentTrack]}"

    fun nextTrack(): String {
        currentTrack++
        if (currentTrack > playlist.size - 1) {
            currentTrack = 0
        }
        return "Playing ${playlist[currentTrack]}"
    }

    fun previousTrack(): String {
        currentTrack--
        if (currentTrack < 0) {
            currentTrack = playlist.size - 1
        }
        return "Playing ${playlist[currentTrack]}"
    }

    fun setCurrentTrackAfterStop() {
        currentTrack = 0
    }
}

class UI(private val player: Player) {
    private val textField = JTextField()

    fun start() {
        val frame = JFrame("Test player")
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        val context = JPanel()
        context.layout = BoxLayout(context, BoxLayout.Y_AXIS)
        frame.contentPane.add(context)
        val buttons = JPanel(FlowLayout(FlowLayout.CENTER))
        context.add(textField)
        context.add(buttons)

        // Context delegates handling user's input to a state object. Naturally,
        // the outcome will depend on what state is currently active, since all
        // states can handle the input differently.

        // Context delegates handling user's input to a state object. Naturally,
        // the outcome will depend on what state is currently active, since all
        // states can handle the input differently.
        val play = JButton("Play")
        play.addActionListener { textField.text = player.state.onPlay() }
        val stop = JButton("Stop")
        stop.addActionListener { textField.text = player.state.onLock() }
        val next = JButton("Next")
        next.addActionListener { textField.text = player.state.onNext() }
        val prev = JButton("Prev")
        prev.addActionListener { textField.text = player.state.onPrevious() }
        frame.isVisible = true
        frame.setSize(300, 100)
        buttons.add(play)
        buttons.add(stop)
        buttons.add(next)
        buttons.add(prev)
    }
}

fun main() {
    val player = Player()
    val ui = UI(player)
    ui.start()
}
