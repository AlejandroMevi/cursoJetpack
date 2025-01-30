package com.example.mycoursecompose.login.data.network

import android.util.Log
import com.example.mycoursecompose.login.data.LoginClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginService @Inject constructor(private val loginClient: LoginClient) {

    suspend fun doLogin(request: LoginRequest): LoginResponse?{
        return withContext(Dispatchers.IO) {
            val response = loginClient.doLogin(request)
            if (response.isSuccessful) {
                response.body()
            } else {
                Log.e("LoginService", "Error en login: ${response.errorBody()?.string()}")
                null
            }
        }
    }
}