package br.com.doghero.dhproject.myhero.service.entity

import com.google.gson.annotations.SerializedName

internal class MyHeroResponseDTO(
    @SerializedName("recents")
    val recents: List<DogHeroUserDTO>,
    @SerializedName("favorites")
    val favorites: List<DogHeroUserDTO>
)