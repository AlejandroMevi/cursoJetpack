package com.example.mycoursecompose.login.data.network

import android.util.Log
import com.example.mycoursecompose.core.RetrofitHelper
import com.example.mycoursecompose.login.data.LoginClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun doLogin(request: LoginRequest): LoginResponse?{
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(LoginClient::class.java).doLogin(request)
            if (response.isSuccessful) {
                response.body()
            } else {
                Log.e("LoginService", "Error en login: ${response.errorBody()?.string()}")
                null
            }
        }
    }
}