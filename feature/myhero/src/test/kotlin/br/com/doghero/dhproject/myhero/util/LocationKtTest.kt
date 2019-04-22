package br.com.doghero.dhproject.myhero.util

import org.junit.Assert.assertEquals
import org.junit.Test

class LocationKtTest {

    @Test
    fun shouldReturnLocationWithPtLanguage() {
        val result = brazilianLocation()

        assertEquals("pt", result.language)
    }

    @Test
    fun shouldReturnLocationWithBrCountry() {
        val result = brazilianLocation()

        assertEquals("BR", result.country)
    }
}
