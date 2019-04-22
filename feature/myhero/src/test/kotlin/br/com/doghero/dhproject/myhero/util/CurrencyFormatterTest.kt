package br.com.doghero.dhproject.myhero.util

import org.junit.Assert.assertEquals
import org.junit.Test
import java.math.BigDecimal

class CurrencyFormatterTest {

    private val currencyFormatter = CurrencyFormatter()

    @Test
    fun shouldFormatCorrectly() {

        assertEquals("R$ 33,40", convertUsingCurrencyFormatter(33.4))
        assertEquals("R$ 33,00", convertUsingCurrencyFormatter(33.toDouble()))
        assertEquals("R$ 33,40", convertUsingCurrencyFormatter(33.4))
        assertEquals("R$ 4,00", convertUsingCurrencyFormatter(4.toDouble()))
        assertEquals("R$ 0,40", convertUsingCurrencyFormatter(0.4))
        assertEquals("R$ 0,04", convertUsingCurrencyFormatter(.04))
    }

    fun convertUsingCurrencyFormatter(value: Double) =
        currencyFormatter.format(BigDecimal.valueOf(value))
}
