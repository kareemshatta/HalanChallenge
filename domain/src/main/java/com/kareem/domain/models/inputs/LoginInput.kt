package com.kareem.domain.models.inputs

import com.kareem.domain.Validator.Validator
import com.kareem.domain.Validator.usernameOrPasswordIsValid

data class LoginInput(
    val username: String,
    val password: String
): Validator {
    override fun validateFields(): Boolean {
        return when {
            !username.usernameOrPasswordIsValid() -> false
            !password.usernameOrPasswordIsValid() -> false
            else -> true
        }
    }
}
