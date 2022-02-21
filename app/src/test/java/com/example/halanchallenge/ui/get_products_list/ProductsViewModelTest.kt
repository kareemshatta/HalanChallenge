package com.example.halanchallenge.ui.get_products_list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.halanchallenge.CoroutinesTestRule
import com.example.halanchallenge.ui.product_list.ProductsListViewModel
import com.kareem.domain.models.entities.LoginResponse
import com.kareem.domain.models.entities.products.ProductsListResponse
import com.kareem.domain.models.inputs.LoginInput
import com.kareem.domain.repositories.auth.AuthRepository
import com.kareem.domain.repositories.products.ProductsRepository
import com.kareem.domain.result.Resource
import com.kareem.domain.useCases.auth.LoginUseCase
import com.kareem.domain.useCases.products.GetProductsListUseCase
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class ProductsViewModelTest : TestCase() {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    private lateinit var repository: ProductsRepository
    private lateinit var useCase: GetProductsListUseCase
    private lateinit var viewModel: ProductsListViewModel

    @Test
    fun givenSuccessState_whenGetProductsList_shouldReturnSuccess() {
        repository = object : ProductsRepository {
            override suspend fun getProductsList(token: String): ProductsListResponse {
                return ProductsListResponse("OK", listOf())
            }
        }
        useCase = GetProductsListUseCase(repository)
        viewModel = ProductsListViewModel(useCase, coroutinesTestRule.testDispatcher)

        runTest {
            viewModel.getProductsList("12345sadgsfdhbfgn67")
            Assert.assertTrue(viewModel.uiState.value is Resource.Success<ProductsListResponse>)
        }
    }
    @Test
    fun givenFailedState_whenGetProductsList_shouldReturnTrue() {
        repository = object : ProductsRepository {
            override suspend fun getProductsList(token: String): ProductsListResponse {
                throw Exception("failed token")
            }
        }
        useCase = GetProductsListUseCase(repository)
        viewModel = ProductsListViewModel(useCase, coroutinesTestRule.testDispatcher)

        runTest {
            viewModel.getProductsList("1111")
            Assert.assertTrue(viewModel.uiState.value is Resource.Error)
        }
    }
    @Test
    fun givenEmptyToken_whenGetProductsList_shouldReturnTrue() {
        repository = object : ProductsRepository {
            override suspend fun getProductsList(token: String): ProductsListResponse {
                throw Exception("empty token")
            }
        }
        useCase = GetProductsListUseCase(repository)
        viewModel = ProductsListViewModel(useCase, coroutinesTestRule.testDispatcher)

        runTest {
            viewModel.getProductsList("")
            Assert.assertTrue(viewModel.uiState.value is Resource.Error)
        }
    }
}