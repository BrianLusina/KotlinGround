package com.kotlinground.design.structuralpatterns.facade

import com.kotlinground.design.creationalpatterns.factory.parser.JsonParser
import com.kotlinground.design.creationalpatterns.factory.server.Server
import com.kotlinground.design.creationalpatterns.factory.parser.YamlParser
import java.lang.RuntimeException
import kotlin.io.path.Path

fun Server.startFromConfiguration(filePath: String) {
    val path = Path(filePath)
    val lines = path.toFile().readLines()
    val config = try {
        JsonParser().server(lines)
    } catch (re: RuntimeException) {
        YamlParser().server(lines)
    }
}
