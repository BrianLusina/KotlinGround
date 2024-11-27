package com.kotlinground.design.creationalpatterns.factory.parser

data class IntProperty(
    override val name: String,
    override val value: Int
) : Property
