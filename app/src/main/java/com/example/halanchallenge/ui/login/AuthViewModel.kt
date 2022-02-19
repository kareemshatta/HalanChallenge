package com.example.halanchallenge.ui.login

import androidx.lifecycle.ViewModel
import com.kareem.domain.models.entities.LoginResponse
import com.kareem.domain.models.inputs.LoginInput
import com.kareem.domain.result.Resource
import com.kareem.domain.useCases.auth.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class AuthViewModel @Inject constructor(
    val loginUseCase: LoginUseCase,
    coroutineDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _uiState = MutableStateFlow<Resource<LoginResponse>>(Resource.Idle())
    val uiState: StateFlow<Resource<LoginResponse>> get() = _uiState

    private var job = Job()
    private val coroutineContext: CoroutineContext = coroutineDispatcher + job

    fun login(loginInput: LoginInput) {
        loginUseCase(loginInput).onEach { result ->
            _uiState.value = result
        }.launchIn(CoroutineScope(coroutineContext))
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}