package br.com.doghero.dhproject.myhero.ui

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.doghero.dhproject.myhero.ui.vo.HeroVO

internal class RecyclerPreparer {

    fun prepareRecyclerView(recyclerView: RecyclerView, list : List<HeroVO>) {
        recyclerView.adapter = HeroAdapter(list)
        recyclerView.addItemDecoration(HeroItemDecoration(recyclerView.resources))
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
    }

}
