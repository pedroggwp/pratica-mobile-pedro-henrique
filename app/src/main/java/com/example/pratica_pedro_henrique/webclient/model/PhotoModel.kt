package com.example.pratica_pedro_henrique.webclient.model

import com.google.gson.annotations.SerializedName

data class PhotoModel(
    val id: String,
    val name: String,
    val url: String,
    val width : Int,
    val height : Int,
    @SerializedName("box_count") val boxCount: Int,
    val captions : Int
)
