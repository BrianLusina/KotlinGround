package com.kotlinground.concurrency.bankaccount

class BankAccount {
    private val lock = Any()
    var balance: Long = 0
        get() {
            synchronized(lock) {
                check(isOpen) { "Account is closed" }
                return field
            }
        }
        private set

    private var isOpen: Boolean = true

    fun adjustBalance(amount: Long) {
        check(isOpen) { "Account is closed" }
        synchronized(lock) {
            balance += amount
        }
    }

    fun close() {
        synchronized(lock) {
            isOpen = false
        }
    }
}
