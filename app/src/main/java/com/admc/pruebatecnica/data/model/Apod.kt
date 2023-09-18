package com.admc.pruebatecnica.data.model

import com.google.gson.annotations.SerializedName

data class Apod(
    @SerializedName("title") var title:String,
    @SerializedName("url") var image:String
)