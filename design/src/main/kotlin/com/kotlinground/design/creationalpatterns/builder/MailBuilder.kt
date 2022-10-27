package com.kotlinground.design.creationalpatterns.builder

class MailBuilder {
    private var to = listOf<String>()
    private var cc = listOf<String>()
    private var title = ""
    private var message = ""
    private var important = false

    class Mail internal constructor(
        val to: List<String>,
        val cc: List<String>?,
        val title: String?,
        val message: String?,
        val important: Boolean,
    )

    fun build(): Mail {
        require(to.isNotEmpty()) { "to property should be provided" }
        return Mail(to, cc, title, message, important)
    }

    fun to(to: List<String>): MailBuilder = apply {
        this.to = to
    }

    fun cc(cc: List<String>): MailBuilder = apply {
        this.cc = cc
    }

    fun title(title: String): MailBuilder = apply {
        this.title = title
    }

    fun message(message: String): MailBuilder = apply {
        this.message = message
    }

    fun important(important: Boolean): MailBuilder = apply {
        this.important = important
    }
}

val email = MailBuilder().to(listOf("hello@example.com")).title("Yo!").build()