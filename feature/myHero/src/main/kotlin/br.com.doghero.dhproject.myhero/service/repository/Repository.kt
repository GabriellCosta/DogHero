package br.com.doghero.dhproject.myhero.service.repository

import androidx.lifecycle.LiveData
import br.com.doghero.dhproject.myhero.service.entity.MyHeroResponseDTO
import br.com.doghero.dhproject.network.ui.UiState

internal interface Repository {

    fun fetchMyHeroes(): LiveData<UiState<MyHeroResponseDTO>>
}
