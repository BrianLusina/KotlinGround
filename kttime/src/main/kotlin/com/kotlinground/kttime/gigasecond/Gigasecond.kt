package com.kotlinground.kttime.gigasecond

import java.time.LocalDate
import java.time.LocalDateTime

/**
 * @author lusinabrian on 20/05/17.
 */
data class Gigasecond(val initialDateTime: LocalDateTime) {
    constructor(initialDateTime: LocalDate) : this(initialDateTime.atTime(0, 0))

    val date = initialDateTime.plusSeconds(1000000000)
}