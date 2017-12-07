package com.kotlinapp.kotlinintro.spektesting

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.Assert.assertEquals

/**
 * @author lusinabrian on 28/05/17.
 */
class CalculatorTest : Spek({
    var calculcator: Calculator? = null

    describe("Calculator") {
        beforeEachTest {
            calculcator = Calculator(NullResult())
        }

        it("Should add 2 numbers") {
            val result = calculcator?.add(5, 5)
            assertEquals(10, result)
        }

        it("should accumulate 1 number") {
            calculcator?.accumulate(25)
            assertEquals(25, calculcator?.total)
        }

        it("should accumulate 2 numbers") {
            calculcator?.accumulate(2)
            calculcator?.accumulate(3)
            assertEquals(5, calculcator?.total)
        }
    }

    describe("Output should be written correctly") {
        it("should write output amount") {
            val result: Result = mock()
            val calculator = Calculator(result)
            it("should write the correct amount") {
                calculator.accumulate(2)
                verify(result).write(2)
            }
        }
    }
})