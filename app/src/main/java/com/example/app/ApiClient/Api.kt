package com.example.app.ApiClient

import com.example.app.Global.AppURLs
import com.example.app.Models.LoginResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET(AppURLs.URL_LOGIN)
    fun userLogin():Call<LoginResponse>
}