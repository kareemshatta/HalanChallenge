package com.kareem.data.remote.dto_models.auth

import com.kareem.domain.mapper.Mapper
import com.kareem.domain.models.entities.Profile

data class ProfileDTO (
    var username: String,
    var image: String,
    var name: String,
    var phone: String,
    var email: String
) : Mapper<ProfileDTO, Profile> {
    override fun map(from: ProfileDTO): Profile = Profile(
        username = from.username,
        image = from.image,
        name = from.name,
        phone = from.phone,
        email = from.email
    )
}