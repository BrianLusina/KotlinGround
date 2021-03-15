package com.kotlinground.patterns.sealed

import java.util.*

/**
 * @author lusinabrian on 06/12/17.
 */
sealed class BookAccess

data class Granted(val expirationDate: Date) : BookAccess()

data class NotGranted(val error: AssertionError) : BookAccess()

data class Blocked(val message: String) : BookAccess()