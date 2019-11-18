package com.jaimerson.thecyrpt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.stfalcon.chatkit.dialogs.DialogsListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chats = arrayOf(Chat(), Chat())

        val dialogsListAdapter = DialogsListAdapter<Chat>(ImageLoader())

        dialogsListAdapter.setItems(chats.toMutableList())

        dialogsListAdapter.setOnDialogClickListener {
            Toast.makeText(this, it.lastMessage.text, Toast.LENGTH_SHORT).show()
        }

        dialogsListAdapter.setOnDialogLongClickListener {
            Toast.makeText(this, "Are you sure you want to delete?", Toast.LENGTH_SHORT).show()
        }

        dialogsList.setAdapter(dialogsListAdapter)
    }
}
