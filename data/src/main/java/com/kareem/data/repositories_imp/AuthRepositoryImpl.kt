package com.kareem.data.repositories_imp

import com.kareem.data.remote.ApiInterface
import com.kareem.domain.repositories.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val service: ApiInterface
    ) : AuthRepository {

}