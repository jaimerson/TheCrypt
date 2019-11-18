package com.jaimerson.thecyrpt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.stfalcon.chatkit.dialogs.DialogsListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chats = arrayOf(Chat(), Chat())

        val dialogsListAdapter = DialogsListAdapter<Chat>(ImageLoader())

        dialogsListAdapter.setItems(chats.toMutableList())

        dialogsList.setAdapter(dialogsListAdapter)
    }
}
