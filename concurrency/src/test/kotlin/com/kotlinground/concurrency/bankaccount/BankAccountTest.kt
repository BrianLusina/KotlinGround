package com.kotlinground.concurrency.bankaccount

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.Random
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class BankAccountTest {
    @Test
    fun zeroBalanceWhenOpened() {
        val account = BankAccount()
        assertEquals(0, account.balance)
    }

    @Test
    fun sequentialBalanceAdjustments() {
        val account = BankAccount()

        account.adjustBalance(1000)
        assertEquals(1000, account.balance)

        account.adjustBalance(-958)
        assertEquals(42, account.balance)
    }

    @Test
    fun closedAccountHasNoBalance() {
        val account = BankAccount()
        account.close()

        assertThrows<IllegalStateException> {
            account.balance
        }
    }

    @Test
    fun closedAccountCannotBeAdjusted() {
        val account = BankAccount()
        account.close()
        assertThrows<IllegalStateException> {
            account.adjustBalance(1000)
        }
    }

    @Test
    fun concurrentBalanceAdjustments() {
        val threads = 100
        val iterations = 500
        val random = Random()

        val account = BankAccount()

        val executor = Executors.newFixedThreadPool(8)

        repeat(threads) {
            executor.submit {
                repeat(iterations) {
                    account.adjustBalance(1)
                    Thread.sleep(random.nextInt(10).toLong())
                    account.adjustBalance(-1)
                }
            }
        }

        executor.shutdown()
        executor.awaitTermination(10, TimeUnit.MINUTES)

        assertEquals(0, account.balance)
    }
}
