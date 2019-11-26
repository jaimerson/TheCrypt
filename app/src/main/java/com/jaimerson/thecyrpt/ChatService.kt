package com.jaimerson.thecyrpt

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Path

interface ChatService {
    @POST("users")
    fun register()

    @FormUrlEncoded
    @POST("users/authenticate")
    fun login(@Field("username") username: String, @Field("password") password: String) : Call<User>

    @POST("users/{username}/update_token")
    fun updateToken(@Path("id") username: String)

//    fun sendMessage()
}