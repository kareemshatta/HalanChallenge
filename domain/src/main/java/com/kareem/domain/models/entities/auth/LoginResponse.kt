package com.kareem.domain.models.entities

import java.io.Serializable

data class LoginResponse(
    var token: String = "",
    var profile: Profile = Profile()
): Serializable