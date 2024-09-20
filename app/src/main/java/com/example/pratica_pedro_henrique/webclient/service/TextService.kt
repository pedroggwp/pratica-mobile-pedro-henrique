package com.example.pratica_pedro_henrique.webclient.service

import com.example.pratica_pedro_henrique.webclient.response.TextResponse
import retrofit2.Response
import retrofit2.http.GET

interface TextService {

    @GET("/v1/random")
    suspend fun getSentence(): Response<TextResponse>

}