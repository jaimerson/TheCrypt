package com.jaimerson.thecyrpt

import com.stfalcon.chatkit.commons.models.IUser

class User : IUser {
    override fun getAvatar(): String {
        return "http://placekitten.com/200/200"
    }

    override fun getName(): String {
        return "John"
    }

    override fun getId(): String {
        return "ID"
    }
}