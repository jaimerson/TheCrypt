package com.jaimerson.thecyrpt

import com.stfalcon.chatkit.commons.models.IUser

class User(val username : String, val publicKey : String) : IUser {
    override fun getAvatar(): String {
        return "http://placekitten.com/200/200"
    }

    override fun getName(): String {
        return this.username
    }

    override fun getId(): String {
        return this.username
    }

    fun getPrivateKey(): String {
        return ""
    }
}