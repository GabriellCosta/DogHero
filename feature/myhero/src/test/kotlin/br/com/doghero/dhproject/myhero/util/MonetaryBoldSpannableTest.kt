package br.com.doghero.dhproject.myhero.util

import android.widget.TextView
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MonetaryBoldSpannableTest {

    private val monetaryBoldSpannable = MonetaryBoldSpannable()
    val textView = mock<TextView>()

    @Before
    fun setup() {
        whenever(textView.text).thenReturn("R$ 45,00")
    }

    @Test
    fun givenATextView_ShouldHaveSpaApplied() {
        monetaryBoldSpannable.makeBold(textView)

        verify(textView).text = any()
    }
}
