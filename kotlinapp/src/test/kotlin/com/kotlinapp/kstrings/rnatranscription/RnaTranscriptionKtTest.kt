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

    
    @Test
    fun cytosineIsGuanine() {
        Assert.assertEquals("G", transcribeToRna("C"))
    }

    
    @Test
    fun guanineIsCytosine() {
        Assert.assertEquals("C", transcribeToRna("G"))
    }

    
    @Test
    fun thymineIsAdenine() {
        Assert.assertEquals("A", transcribeToRna("T"))
    }

    
    @Test
    fun adenineIsUracil() {
        Assert.assertEquals("U", transcribeToRna("A"))
    }

    
    @Test
    fun rnaTranscription() {
        Assert.assertEquals("UGCACCAGAAUU", transcribeToRna("ACGTGGTCTTAA"))
    }

}