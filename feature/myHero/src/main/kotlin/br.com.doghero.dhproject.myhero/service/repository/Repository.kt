package br.com.doghero.dhproject.myhero.service.repository

import br.com.doghero.dhproject.myhero.service.entity.MyHeroResponseDTO
import br.com.doghero.dhproject.network.ui.UiStateLiveData

internal interface Repository {

    fun fetchMyHeroes(): UiStateLiveData<MyHeroResponseDTO>
}