package br.com.doghero.dhproject.myhero.service.entity

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

internal class DogHeroUserDTO(
    @SerializedName("is_superhero")
    val superHero: Boolean,
    @SerializedName("user")
    val user: UserDTO,
    @SerializedName("address_neighborhood")
    val address: String,
    @SerializedName("price")
    val price: BigDecimal
)
