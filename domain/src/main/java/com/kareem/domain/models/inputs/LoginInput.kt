package com.kareem.domain.models.inputs

data class LoginInput(
    val username: String,
    val password: String
) {
    fun validateInputData(): Boolean {
        return when {
            textISNotValid(username) -> false
            textISNotValid(password) -> false
            else -> true
        }
    }

    private fun textISNotValid(text: String): Boolean {
        return (text.isEmpty() || text.length !in 6..15)
    }
}
