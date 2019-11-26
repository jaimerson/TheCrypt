package com.jaimerson.thecyrpt

import retrofit2.http.POST
import retrofit2.http.Path

interface ChatService {
    @POST("users")
    fun register()

    @POST("users/authenticate")
    fun login()

    @POST("users/{username}/update_token")
    fun updateToken(@Path("id") username: String)

//    fun sendMessage()
}