package com.jaimerson.thecyrpt

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Path

interface ChatService {
    @FormUrlEncoded
    @POST("users")
    fun signUp(@Field("username") username: String,
               @Field("password") password: String,
               @Field("public_key") publicKey: String
    ) : Call<User>

    @FormUrlEncoded
    @POST("users/authenticate")
    fun login(@Field("username") username: String, @Field("password") password: String) : Call<User>

    @FormUrlEncoded
    @POST("users/{username}/update_token")
    fun updateToken(@Path("id") username: String, @Field("firebase_token") token: String) : Call<User>

//    fun sendMessage()
}