package com.example.halanchallenge.ui.login

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.halanchallenge.CoroutinesTestRule
import com.kareem.domain.models.entities.LoginResponse
import com.kareem.domain.models.inputs.LoginInput
import com.kareem.domain.repositories.auth.AuthRepository
import com.kareem.domain.result.Resource
import com.kareem.domain.useCases.auth.LoginUseCase
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
class AuthViewModelTest : TestCase() {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    private lateinit var repository: AuthRepository
    private lateinit var useCase: LoginUseCase
    private lateinit var viewModel: AuthViewModel
    private lateinit var loginInput: LoginInput

    @Before
    public override fun setUp() {
        super.setUp()
        repository = object : AuthRepository {
            override suspend fun login(loginInput: LoginInput): LoginResponse {
                return LoginResponse()
            }
        }
        useCase = LoginUseCase(repository)
        viewModel = AuthViewModel(useCase, coroutinesTestRule.testDispatcher)
    }

    @Test
    fun givenSuccessState_whenLogin_shouldReturnSuccess() {
        loginInput = LoginInput(
            username = "kareem1",
            password = "kareem1",
        )
        runTest {
            viewModel.login(loginInput)
            Assert.assertTrue(viewModel.uiState.value is Resource.Success<LoginResponse>)
        }
    }
    @Test
    fun givenFailedState_whenLogin_shouldReturnTrue() {
        loginInput = LoginInput(
            username = "123",
            password = "123",
        )
        runTest {
            viewModel.login(loginInput)
            Assert.assertTrue(viewModel.uiState.value is Resource.Error)
        }
    }
    @Test
    fun givenEmptyInput_whenLogin_shouldReturnTrue() {
        loginInput = LoginInput("","")
        runTest {
            viewModel.login(loginInput)
            Assert.assertTrue(viewModel.uiState.value is Resource.Error)
        }
    }
}