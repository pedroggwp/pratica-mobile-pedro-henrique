package com.example.pratica_pedro_henrique.webclient.service

import com.example.pratica_pedro_henrique.webclient.response.PhotoResponse
import retrofit2.Response
import retrofit2.http.GET

interface PhotoService {

    @GET("/get_memes")
    suspend fun getPhoto(): Response<PhotoResponse>

}