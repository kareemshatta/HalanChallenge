package com.kareem.domain.models.entities

data class LoginResponse(
    var token: String = "",
    var profile: Profile = Profile()
)