package com.example.mycoursecompose.login.data.network

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName(value = "token") val token: String
)
