package com.kotlinground.design.behavioralpatterns.visitor.crawler

object Image : HtmlElement() {
    val src: String
        get() = "https://some.image"
}
