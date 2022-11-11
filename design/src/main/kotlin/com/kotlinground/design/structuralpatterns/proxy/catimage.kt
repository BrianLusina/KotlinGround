package com.kotlinground.design.structuralpatterns.proxy

import java.net.URL

data class CatImage(val thumbnailUrl: String, val url: String) {
    val image: ByteArray by lazy {
        URL(url).readBytes()
    }
}
