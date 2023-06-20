package com.example.app.Models

import com.google.gson.annotations.SerializedName

data class LoginResponse(

    @field:SerializedName("response")
    val response: LoginResponse? = null,

    @field:SerializedName("header")
    val header: Header? = null,

    @field:SerializedName("session_id")
    val sessionId: String? = null,

    @field:SerializedName("billingAccount")
    val billingAccount: String? = null,

    @field:SerializedName("socialReason")
    val socialReason: String? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("token")
    val token: String? = null
)

data class Header(

    @field:SerializedName("code")
    val code: Int? = null,

    @field:SerializedName("message")
    val message: String? = null
)
