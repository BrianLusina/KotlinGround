package com.kotlinground.ktmath.primes

import org.junit.jupiter.api.Assertions.assertEquals
import java.util.Arrays
import java.util.Random
import org.junit.Test

class StepsinprimesKtTest {
    //--------------
    @Test
    fun test() {
        println("Fixed Tests")
        assertEquals("[101, 103]", step(2, 100, 110).contentToString())
        assertEquals("[103, 107]", Arrays.toString(step(4, 100, 110)))
        assertEquals("[101, 107]", Arrays.toString(step(6, 100, 110)))
        assertEquals("[359, 367]", Arrays.toString(step(8, 300, 400)))
        assertEquals("[307, 317]", Arrays.toString(step(10, 300, 400)))
        assertEquals("[30109, 30113]", Arrays.toString(step(4, 30000, 100000)))
        assertEquals("[30091, 30097]", Arrays.toString(step(6, 30000, 100000)))
        assertEquals("[30089, 30097]", Arrays.toString(step(8, 30000, 100000)))
        assertEquals(Arrays.toString(longArrayOf()), Arrays.toString(step(11, 30000, 100000)))
        assertEquals("[10000139, 10000141]", Arrays.toString(step(2, 10000000, 11000000)))
        assertEquals("[1321, 1373]", Arrays.toString(step(52, 1300, 150000)))
        assertEquals("[4909, 4919]", Arrays.toString(step(10, 4900, 5000)))
        assertEquals("[4903, 4933]", Arrays.toString(step(30, 4900, 5000)))
        assertEquals("[4931, 4933]", Arrays.toString(step(2, 4900, 5000)))
        assertEquals("[104087, 104089]", Arrays.toString(step(2, 104000, 105000)))
        assertEquals(Arrays.toString(longArrayOf()), Arrays.toString(step(2, 4900, 4919)))
        assertEquals(Arrays.toString(longArrayOf()), Arrays.toString(step(7, 4900, 4919)))
        assertEquals("[30133, 30137]", Arrays.toString(step(4, 30115, 100000)))
        assertEquals("[30319, 30323]", Arrays.toString(step(4, 30140, 100000)))
        assertEquals("[30109, 30113]", Arrays.toString(step(4, 30000, 30325)))
    }

    @Test
    fun test1() {
        println("100 Random Tests")
        for (i in 0..99) {
            var n: Long = 0
            if (randInt(0, 99) % 5 == 0)
                n = randLong(1000, 2000)
            else
                n = randLong(100000, 1000000)
            //println(n);
            //println("****");
            assertEquals(
                Arrays.toString(stepSol1(2, n, n + 1000)),
                Arrays.toString(step(2, n, n + 1000))
            )
        }
    }

    companion object {
        private fun randInt(min: Int, max: Int): Int {
            return min + (Math.random() * ((max - min) + 1)).toInt()
        }

        private fun randLong(low: Long, high: Long): Long {
            val LOWER_RANGE = low
            val UPPER_RANGE = high
            val random = Random()
            val randomValue = (LOWER_RANGE + (random.nextDouble() * (UPPER_RANGE - LOWER_RANGE)).toLong())
            return randomValue
        }

        //--------------
        private fun primeSol1(n: Long): Boolean {
            if (n == 2L)
                return true
            else if ((n < 2) || (n % 2 == 0L))
                return false
            else {
                var i: Long = 3
                while (i <= Math.sqrt(n.toDouble())) {
                    if (n % i == 0L) return false
                    ++i
                }
                return true
            }
        }

        fun stepSol1(g: Int, m: Long, n: Long): LongArray {
            var res = LongArray(2)
            var i = m
            while (i <= n - g) {
                if (primeSol1(i) && primeSol1(i + g)) {
                    res[0] = i
                    res[1] = i + g
                    return res
                }
                i++
            }
            return longArrayOf()
        }
    }
}