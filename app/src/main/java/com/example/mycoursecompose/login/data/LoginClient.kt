package com.example.mycoursecompose.login.data

import com.example.mycoursecompose.login.data.network.LoginRequest
import com.example.mycoursecompose.login.data.network.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface LoginClient {
    @POST("login")
    suspend fun doLogin(@Body request: LoginRequest): Response<LoginResponse>
}

