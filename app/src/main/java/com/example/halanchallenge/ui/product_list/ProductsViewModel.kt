package com.example.halanchallenge.ui.product_list

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
class ProductsViewModel @Inject constructor(
    coroutineDispatcher: CoroutineDispatcher
) : ViewModel() {

    private var job = Job()
    private val coroutineContext: CoroutineContext = coroutineDispatcher + job


    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}