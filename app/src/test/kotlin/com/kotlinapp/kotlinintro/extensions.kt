package com.kotlinapp.kotlinintro

/**
 * @author lusinabrian on 07/12/17.
 */
import org.junit.Test
import java.util.*
import kotlin.test.assertEquals


operator fun kotlin.Int.Companion.invoke(s: String) = s.toInt()
operator fun kotlin.Long.Companion.invoke(s: String) = s.toLong()
operator fun kotlin.Double.Companion.invoke(s: String) = s.toDouble()

class KotlinTricks {
    @Test
    fun testInt() {
        val r = Random(System.currentTimeMillis())
        (0..100).forEach { r.nextInt().let { assertEquals(it, kotlin.Int(it.toString())) } }
    }
}