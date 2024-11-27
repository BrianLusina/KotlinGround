package com.kotlinground.design.creationalpatterns.factory.parser

data class ServerConfigImpl(
    override val properties: List<Property>
) : ServerConfig
