package com.kareem.domain.Validator

fun String.usernameOrPasswordIsValid(): Boolean {
    return !(isEmpty() || length !in 6..15)
}