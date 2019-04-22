package br.com.doghero.dhproject.myhero.util

import java.math.BigDecimal
import java.text.NumberFormat

internal class CurrencyFormatter {

    private val formatter = NumberFormat.getCurrencyInstance(brazilianLocation())

    fun format(value: BigDecimal): String = formatter.format(value)
}
