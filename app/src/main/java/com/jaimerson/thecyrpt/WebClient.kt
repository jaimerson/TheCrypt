package com.jaimerson.thecyrpt

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WebClient {
    private var retrofit: Retrofit

    constructor(){
        this.retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.0.21:3000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun chatService(){
        this.retrofit.create(ChatService::class.java)
    }
}