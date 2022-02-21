package com.kareem.data.remote.dto_models.auth

import com.kareem.domain.mapper.Mapper
import com.kareem.domain.models.entities.LoginResponse

data class LoginResponseDTO(
    var token: String,
    var profile: ProfileDTO
) : Mapper<LoginResponseDTO, LoginResponse> {
    override fun map(from: LoginResponseDTO): LoginResponse = LoginResponse(
        token = from.token,
        profile = from.profile.map(from.profile)
    )
}