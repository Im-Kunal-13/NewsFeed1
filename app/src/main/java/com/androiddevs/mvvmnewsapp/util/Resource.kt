package com.androiddevs.mvvmnewsapp.util

// recommended by google to be wrapped around by our network responses.
// handle the loading state.
// handle error or success response.

// Sealed class is like abstract classes but we are allowed to define which classes are allowed to inherit from the class. i.e the Resource class.
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null

) {
    class Success<T>(data: T): Resource<T>(data)
    class Error<T>(message: String, data: T? = null): Resource<T>(data, message)
    class Loading<T>: Resource<T>()
}