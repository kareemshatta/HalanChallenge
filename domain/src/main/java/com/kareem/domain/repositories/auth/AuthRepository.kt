package com.kareem.domain.repositories.auth

import com.kareem.domain.models.entities.LoginResponse
import com.kareem.domain.models.inputs.LoginInput

interface AuthRepository {
    suspend fun login(loginInput: LoginInput): LoginResponse
}