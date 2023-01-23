package com.kotlinground.design.behavioralpatterns.visitor.crawler

object Link : HtmlElement() {
    val href: String
        get() = "https://some.link"
}
