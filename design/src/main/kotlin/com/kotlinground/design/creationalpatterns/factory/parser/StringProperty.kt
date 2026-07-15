package com.kotlinground.design.creationalpatterns.factory.parser

data class StringProperty(
    override val name: String,
    override val value: String
) : Property
