package br.com.doghero.dhproject.myhero.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.doghero.dhproject.commons.di.viewModel
import br.com.doghero.dhproject.myhero.R
import br.com.doghero.dhproject.myhero.ui.vo.HeroVO
import br.com.doghero.dhproject.myhero.util.bind
import br.com.doghero.dhproject.myhero.viewmodel.MyHeroesViewModel
import br.com.doghero.dhproject.network.ui.observeOnSuccess
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein

class HeroListActivity : AppCompatActivity(), KodeinAware {

    override val kodein: Kodein by closestKodein()
    private val viewModel: MyHeroesViewModel by viewModel()

    private val recentListView by bind<RecyclerView>(R.id.rv_hero_list_recent)
    private val favoriteListView by bind<RecyclerView>(R.id.rv_hero_list_favorite)
    private val loading by bind<View>(R.id.loading_hero_list)
    private val scrollView by bind<View>(R.id.scroll_hero_list)

    private val recyclerPreparer = RecyclerPreparer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_hero_list)
        prepareLayout()
    }

    private fun prepareLayout() {
        viewModel.myHeroes.observeOnSuccess(this, ::fetchSuccess)

        viewModel.recents
            .observeOnSuccess(this, ::recentsSuccess)

        viewModel.favorites
            .observeOnSuccess(this, ::favoriteSuccess)

        viewModel.fetchHeroes()
    }

    private fun fetchSuccess() {
        loading.visibility = View.GONE
        scrollView.visibility = View.VISIBLE
    }

    private fun recentsSuccess(list: List<HeroVO>) {
        recyclerPreparer.prepareRecyclerView(recentListView, list)
    }

    private fun favoriteSuccess(list: List<HeroVO>) {
        recyclerPreparer.prepareRecyclerView(favoriteListView, list)
    }
}
