package com.kareem.domain.useCases.auth

import com.kareem.domain.models.entities.LoginResponse
import com.kareem.domain.models.inputs.LoginInput
import com.kareem.domain.repositories.AuthRepository
import com.kareem.domain.result.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    operator fun invoke(loginInput: LoginInput): Flow<Resource<LoginResponse>> = flow {
        try {
            emit(Resource.Loading())
            if (loginInput.validateFields()) {
                val loginResponse = repository.login(loginInput)
                emit(Resource.Success(loginResponse))
            } else {
                throw Exception("Enter valid user name or password")
            }
        } catch (e: Exception) {
            if (e !is CancellationException) {
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
            }
        }
    }
}