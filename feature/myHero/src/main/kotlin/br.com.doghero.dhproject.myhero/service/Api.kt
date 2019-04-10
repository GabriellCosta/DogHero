package br.com.doghero.dhproject.myhero.service

import androidx.lifecycle.LiveData
import br.com.doghero.dhproject.myhero.service.entity.DogHeroUserDTO
import br.com.doghero.dhproject.network.ui.UiState
import retrofit2.http.GET

internal interface Api {

    @GET("/doghero/myhero")
    fun fetchHeroes(): LiveData<UiState<DogHeroUserDTO>>
}
