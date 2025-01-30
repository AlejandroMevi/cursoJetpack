package com.example.mycoursecompose.login.domain

import com.example.mycoursecompose.login.data.LoginRepository
import com.example.mycoursecompose.login.data.network.LoginRequest
import com.example.mycoursecompose.login.data.network.LoginResponse
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: LoginRepository){

    suspend operator fun invoke(request: LoginRequest): LoginResponse? {
        return repository.doLogin(request)
    }
}