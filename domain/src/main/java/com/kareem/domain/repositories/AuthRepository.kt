package com.kareem.domain.repositories

import com.kareem.domain.models.entities.LoginResponse
import com.kareem.domain.models.inputs.LoginInput

interface AuthRepository {
    suspend fun login(loginInput: LoginInput): LoginResponse
}