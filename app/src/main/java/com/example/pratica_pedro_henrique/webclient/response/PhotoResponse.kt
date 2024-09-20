package com.example.pratica_pedro_henrique.webclient.response

import com.example.pratica_pedro_henrique.webclient.data.PhotoData

data class PhotoResponse(
    val success: Boolean,
    val data: PhotoData
)