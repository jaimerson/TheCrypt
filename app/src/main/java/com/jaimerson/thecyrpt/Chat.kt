package com.jaimerson.thecyrpt

import com.stfalcon.chatkit.commons.models.IDialog
import com.stfalcon.chatkit.commons.models.IMessage
import com.stfalcon.chatkit.commons.models.IUser

class Chat : IDialog<IMessage> {
    override fun getDialogPhoto(): String {
        return "http://placekitten.com/200/200"
    }

    override fun getUnreadCount(): Int {
        return 42
    }

    override fun setLastMessage(message: IMessage?) {
        1 + 1 // NOOP
    }

    override fun getId(): String {
        return "ID"
    }

    override fun getUsers(): MutableList<out IUser> {
        return arrayOf(User()).toMutableList()
    }

    override fun getLastMessage(): IMessage {
        return Message()
    }

    override fun getDialogName(): String {
        return "HEYO"
    }

}
