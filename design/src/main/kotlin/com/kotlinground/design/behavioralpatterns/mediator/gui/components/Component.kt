package com.kotlinground.design.behavioralpatterns.mediator.gui.components

import com.kotlinground.design.behavioralpatterns.mediator.gui.mediator.Mediator

interface Component {
    val mediator: Mediator
    val name: String
}
