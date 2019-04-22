package br.com.doghero.dhproject.myhero.viewmodel

import androidx.lifecycle.ViewModel
import br.com.doghero.dhproject.myhero.service.repository.RepositoryImpl
import br.com.doghero.dhproject.myhero.ui.vo.HeroVO
import br.com.doghero.dhproject.network.ui.UiStateLiveData
import br.com.doghero.dhproject.network.ui.UiSuccess

internal class MyHeroesViewModel(private val repositoryImpl: RepositoryImpl) : ViewModel() {

    val recents = UiStateLiveData<List<HeroVO>>()
    val favorites = UiStateLiveData<List<HeroVO>>()

    private val uiTransformer = HeroTransformer()

    val myHeroes = UiStateLiveData<Unit>()

    fun fetchHeroes() {
        myHeroes.swapSource(repositoryImpl.fetchMyHeroes()) {

            val recentList = it.recents.map(uiTransformer::map)

            recents.postValue(UiSuccess(recentList))

            val favoriteList = it.favorites.map(uiTransformer::map)

            favorites.postValue(UiSuccess(favoriteList))
        }
    }
}
