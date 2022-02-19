package com.kareem.data.repositories_imp

import com.kareem.data.remote.ApiInterface
import com.kareem.domain.models.entities.LoginResponse
import com.kareem.domain.models.inputs.LoginInput
import com.kareem.domain.repositories.AuthRepository
import org.json.JSONObject
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val service: ApiInterface
) : AuthRepository {
    override suspend fun login(loginInput: LoginInput): LoginResponse {
        val inputMap = HashMap<String, String>()
        inputMap["username"] = loginInput.username
        inputMap["password"] = loginInput.password

        val response = service.login(inputMap)
        if (response.isSuccessful) {
            return response.body()!!.map(response.body()!!)
        } else {
            val jsonObject = JSONObject(response.errorBody()?.string())
            val errorMessage = jsonObject.get("message").toString()
            throw Exception(errorMessage)
        }
    }
}