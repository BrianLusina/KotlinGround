import com.kotlinapp.algorithms.hamming.Hamming
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import kotlin.test.assertEquals

class HammingTest {

    @Rule
    @JvmField
    var expectedException: ExpectedException = ExpectedException.none()

    @Test
    fun noDistanceBetweenEmptyStrands() {
        assertEquals(0, Hamming.compute("", ""))
    }

    @Ignore
    @Test
    fun noDistanceBetweenShortIdenticalStrands() {
        assertEquals(0, Hamming.compute("A", "A"))
    }

    @Ignore
    @Test
    fun noDistanceBetweenLongIdenticalStrands() {
        assertEquals(0, Hamming.compute("GGACTGA", "GGACTGA"))
    }

    @Ignore
    @Test
    fun completeDistanceInSingleNucleotideStrand() {
        assertEquals(1, Hamming.compute("A", "G"))
    }

    @Ignore
    @Test
    fun completeDistanceInSmallStrand() {
        assertEquals(2, Hamming.compute("AG", "CT"))
    }

    @Ignore
    @Test
    fun smallDistanceInSmallStrand() {
        assertEquals(1, Hamming.compute("AT", "CT"))
    }

    @Ignore
    @Test
    fun smallDistanceInMediumStrand() {
        assertEquals(1, Hamming.compute("GGACG", "GGTCG"))
    }

    @Ignore
    @Test
    fun smallDistanceInLongStrand() {
        assertEquals(2, Hamming.compute("ACCAGGG", "ACTATGG"))
    }

    @Ignore
    @Test
    fun nonUniqueCharacterInFirstStrand() {
        assertEquals(1, Hamming.compute("AGA", "AGG"))
    }

    @Ignore
    @Test
    fun nonUniqueCharacterInSecondStrand() {
        assertEquals(1, Hamming.compute("AGG", "AGA"))
    }

    @Ignore
    @Test
    fun sameNucleotidesInDifferentPositions() {
        assertEquals(2, Hamming.compute("TAG", "GAT"))
    }

    @Ignore
    @Test
    fun largeDistanceInPermutedStrand() {
        assertEquals(4, Hamming.compute("GATACA", "GCATAA"))
    }

    @Ignore
    @Test
    fun largeDistanceInOffByOneStrand() {
        assertEquals(9, Hamming.compute("GGACGGATTCTG", "AGGACGGATTCT"))
    }

    @Ignore
    @Test
    fun validatesFirstStrandNotLonger() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("leftStrand and rightStrand must be of equal length.")

        Hamming.compute("AATG", "AAA")
    }

    @Ignore
    @Test
    fun validatesSecondStrandNotLonger() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("leftStrand and rightStrand must be of equal length.")

        Hamming.compute("ATA", "AGTG")
    }

}