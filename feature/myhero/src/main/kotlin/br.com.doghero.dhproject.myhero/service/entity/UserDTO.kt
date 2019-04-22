package br.com.doghero.dhproject.myhero.service.entity

import com.google.gson.annotations.SerializedName

internal class UserDTO(
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("image_url")
    val imageUrl: String
)
