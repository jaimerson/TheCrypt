package com.jaimerson.thecyrpt

import com.stfalcon.chatkit.commons.models.IMessage
import com.stfalcon.chatkit.commons.models.IUser
import java.util.*

class Message : IMessage{
    override fun getId(): String {
        return "42"
    }

    override fun getCreatedAt(): Date {
        return Date()
    }

    override fun getUser(): IUser {
        return User("", "")
    }

    override fun getText(): String {
        return "HAHAHEAUEA"
    }
}