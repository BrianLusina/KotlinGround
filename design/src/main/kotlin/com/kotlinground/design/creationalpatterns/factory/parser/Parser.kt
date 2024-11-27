/**
 * Demonstrates how to create abstract factory methods
 */
package com.kotlinground.design.creationalpatterns.factory.parser

interface Parser {
    fun property(prop: String): Property
    fun server(props: List<String>): ServerConfig
}
