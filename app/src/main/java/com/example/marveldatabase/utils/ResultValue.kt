package com.example.marveldatabase.utils

sealed class ResultValue<T>(val data: T?) {
    class Success<T>(data: T) : ResultValue<T>(data)
    class Failure<T>(data: T?, val error: String? = null) : ResultValue<T>(data)
    class Waiting<T>(data: T?) : ResultValue<T>(data)
}