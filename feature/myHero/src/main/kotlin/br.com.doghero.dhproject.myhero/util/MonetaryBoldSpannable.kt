package br.com.doghero.dhproject.myhero.util

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.widget.TextView
import java.text.NumberFormat

internal class MonetaryBoldSpannable {

    private val symbol = NumberFormat.getCurrencyInstance(brazilianLocation()).currency.symbol

    fun makeBold(textView: TextView) {
        val spannable = SpannableStringBuilder(textView.text.toString())

        val typeFace = StyleSpan(Typeface.BOLD)
        val start = textView.text.indexOf(symbol) + symbol.length
        val end = textView.text.length
        val spannableStyle = Spannable.SPAN_EXCLUSIVE_EXCLUSIVE

        spannable.setSpan(typeFace, start, end, spannableStyle)

        textView.text = spannable
    }
}
