package com.example.mycoursecompose.login.data

import com.example.mycoursecompose.login.data.network.LoginRequest
import com.example.mycoursecompose.login.data.network.LoginResponse
import com.example.mycoursecompose.login.data.network.LoginService

class LoginRepository {
    private val api = LoginService()

    suspend fun doLogin(request: LoginRequest): LoginResponse? {
        return api.doLogin(request)
    }
}