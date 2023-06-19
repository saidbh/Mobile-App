package com.example.app.ApiClient

import com.example.app.Models.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET


interface Api {
    @FormUrlEncoded
    @GET("userLogin")
    fun userLogin(
        @Field("username") email:String,
        @Field("password") password: String
    ):Call<LoginResponse>
}