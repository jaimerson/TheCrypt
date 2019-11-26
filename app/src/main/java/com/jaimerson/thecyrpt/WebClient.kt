package com.jaimerson.thecyrpt

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WebClient {
    private var retrofit: Retrofit

    constructor(){
        this.retrofit = Retrofit.Builder()
            .baseUrl("http://10.51.68.57:3000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun chatService() : ChatService{
        return this.retrofit.create(ChatService::class.java)
    }
}