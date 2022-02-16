package com.kareem.domain.result

sealed class DataSource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Loading<T> : DataSource<T>()
    class Success<T>(data: T) : DataSource<T>(data)
    class Error<T>(message: String, data: T? = null) : DataSource<T>(data, message)
}