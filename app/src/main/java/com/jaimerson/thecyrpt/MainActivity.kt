package com.jaimerson.thecyrpt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.stfalcon.chatkit.commons.ImageLoader
import com.stfalcon.chatkit.dialogs.DialogsListAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chats = arrayOf(Chat(), Chat())

        val adapter = DialogsListAdapter<Chat>(new ImageLoader() {
            
        })
    }
}
