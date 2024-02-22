package com.kotlinground.datastructures.snapshotarray

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SnapshotArrayTest {

    @Test
    fun `set(3) - snap(0, 5) - set(0, 6) - get(0, 0)`() {
        val snapshotArray = SnapshotArray(3)
        snapshotArray.set(0, 5)

        val expectedFirstSnap = 0
        val actualFirstSnap = snapshotArray.snap()

        assertEquals(expectedFirstSnap, actualFirstSnap)

        snapshotArray.set(0, 6)

        val expectedFirstSnapId = 5
        val actualFirstSnapId = snapshotArray.get(0, 0)

        assertEquals(expectedFirstSnapId, actualFirstSnapId)
    }
}
