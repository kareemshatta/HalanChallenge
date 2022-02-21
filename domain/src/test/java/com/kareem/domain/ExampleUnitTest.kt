package com.kareem.domain

import com.kareem.domain.Validator.usernameOrPasswordIsValid
import com.kareem.domain.models.entities.LoginResponse
import com.kareem.domain.models.inputs.LoginInput
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class ExampleUnitTest {

    private lateinit var loginInput: LoginInput
    private lateinit var userName: String

    @Test
    fun givenValidUserName_whenValidateIt_shouldReturnTrue() {
        userName = "kareem1"
        assertTrue(userName.usernameOrPasswordIsValid())
    }
    @Test
    fun givenNotValidUserName_whenValidateIt_shouldReturnFalse() {
        userName = "123"
        assertTrue(!userName.usernameOrPasswordIsValid())
    }
    @Test
    fun givenValidLoginInput_whenValidateIt_shouldReturnTrue() {
        loginInput = LoginInput("kareem1","kareem1")
        assertTrue(loginInput.validateFields())
    }
    @Test
    fun givenNotValidLoginInput_whenValidateIt_shouldReturnFalse() {
        loginInput = LoginInput("123","123")
        assertTrue(!loginInput.validateFields())
    }

}