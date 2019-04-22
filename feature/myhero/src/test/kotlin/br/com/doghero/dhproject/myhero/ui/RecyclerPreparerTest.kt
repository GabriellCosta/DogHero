package br.com.doghero.dhproject.myhero.ui

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.doghero.dhproject.myhero.ui.vo.HeroVO
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test

class RecyclerPreparerTest {

    private val recyclerPreparer = RecyclerPreparer()
    val recyclerView = mock<RecyclerView>()

    @Before
    fun setup() {
        whenever(recyclerView.resources).thenReturn(mock())
    }

    @Test
    fun givenRecyclerView_whenApplied_ShouldAddHeroAdapter() {
        val list = mock<List<HeroVO>>()

        recyclerPreparer.prepareRecyclerView(recyclerView, list)

        verify(recyclerView).adapter = any<HeroAdapter>()
    }

    @Test
    fun givenRecyclerView_whenApplied_ShouldAddHeroItemDecoration() {
        val list = mock<List<HeroVO>>()

        recyclerPreparer.prepareRecyclerView(recyclerView, list)

        verify(recyclerView).addItemDecoration(any<HeroItemDecoration>())
    }

    @Test
    fun givenRecyclerView_whenApplied_ShouldHaveLinearLayoutManger() {
        val list = mock<List<HeroVO>>()

        recyclerPreparer.prepareRecyclerView(recyclerView, list)

        verify(recyclerView).layoutManager = any<LinearLayoutManager>()
    }
}
