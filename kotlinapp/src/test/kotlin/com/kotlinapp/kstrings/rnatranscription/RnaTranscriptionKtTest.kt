package com.kotlinapp.kstrings.rnatranscription

import org.junit.Assert
import org.junit.Ignore
import org.junit.Test

/**
 * @author lusinabrian on 29/05/17.
 */
class RnaTranscriptionKtTest{
    @Test
    fun emptyDnaIsEmptyRna() {
        Assert.assertEquals("", transcribeToRna(""))
    }

    @Ignore
    @Test
    fun cytosineIsGuanine() {
        Assert.assertEquals("G", transcribeToRna("C"))
    }

    @Ignore
    @Test
    fun guanineIsCytosine() {
        Assert.assertEquals("C", transcribeToRna("G"))
    }

    @Ignore
    @Test
    fun thymineIsAdenine() {
        Assert.assertEquals("A", transcribeToRna("T"))
    }

    @Ignore
    @Test
    fun adenineIsUracil() {
        Assert.assertEquals("U", transcribeToRna("A"))
    }

    @Ignore
    @Test
    fun rnaTranscription() {
        Assert.assertEquals("UGCACCAGAAUU", transcribeToRna("ACGTGGTCTTAA"))
    }

}