package br.com.doghero.dhproject.myhero.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.doghero.dhproject.myhero.R
import br.com.doghero.dhproject.myhero.service.Api
import br.com.doghero.dhproject.myhero.service.repository.RepositoryImpl
import br.com.doghero.dhproject.myhero.ui.vo.HeroVO
import br.com.doghero.dhproject.myhero.util.bind
import br.com.doghero.dhproject.myhero.viewmodel.MyHeroesViewModel
import br.com.doghero.dhproject.network.NetworkClient
import br.com.doghero.dhproject.network.ui.observeOnSuccess

class HeroListActivity : AppCompatActivity() {

    private val recentListView by bind<RecyclerView>(R.id.rv_hero_list_recent)
    private val favoriteListView by bind<RecyclerView>(R.id.rv_hero_list_favorite)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_hero_list)
        prepareLayout()
    }

    private fun prepareLayout() {
        val viewModel = MyHeroesViewModel(RepositoryImpl(NetworkClient.getApi(Api::class.java)))

        viewModel.myHeroes.observe(this, Observer {
            Log.d("HeroListActivity", "Initial observer")
        })

        viewModel.recents
            .observeOnSuccess(this, ::recentsSuccess)

        viewModel.favorites
            .observeOnSuccess(this, ::favoriteSuccess)

        viewModel.fetchHeroes()
    }

    private fun recentsSuccess(list : List<HeroVO>) {
        recentListView.adapter = HeroAdapter(list)
        recentListView.addItemDecoration(HeroItemDecoration(resources))
        recentListView.layoutManager = LinearLayoutManager(this)

    }

    private fun favoriteSuccess(list : List<HeroVO>) {
        favoriteListView.adapter = HeroAdapter(list)
        favoriteListView.addItemDecoration(HeroItemDecoration(resources))
        favoriteListView.layoutManager = LinearLayoutManager(this)
    }
}
