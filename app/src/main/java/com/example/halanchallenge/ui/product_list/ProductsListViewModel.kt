package com.example.halanchallenge.ui.product_list

import androidx.lifecycle.ViewModel
import com.kareem.domain.models.entities.LoginResponse
import com.kareem.domain.models.entities.products.ProductsListResponse
import com.kareem.domain.models.inputs.LoginInput
import com.kareem.domain.result.Resource
import com.kareem.domain.useCases.auth.LoginUseCase
import com.kareem.domain.useCases.products.GetProductsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class ProductsListViewModel @Inject constructor(
    private val getProductsListUseCase: GetProductsListUseCase,
    coroutineDispatcher: CoroutineDispatcher
) : ViewModel() {

    private var job = Job()
    private val coroutineContext: CoroutineContext = coroutineDispatcher + job

    private val _uiState = MutableStateFlow<Resource<ProductsListResponse>>(Resource.Idle())
    val uiState: StateFlow<Resource<ProductsListResponse>> get() = _uiState

    fun getProductsList(token: String) {
        getProductsListUseCase(token).onEach { result ->
            _uiState.value = result
        }.launchIn(CoroutineScope(coroutineContext))
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}