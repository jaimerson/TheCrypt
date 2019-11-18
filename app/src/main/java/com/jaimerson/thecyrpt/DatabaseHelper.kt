package com.jaimerson.thecyrpt

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("""
            CREATE TABLE $CHATS_TABLE_NAME (
                id INTEGER PRIMARY KEY,
                username TEXT NOT NULL,
                public_key TEXT NOT NULL
            );
            CREATE TABLE $MESSAGES_TABLE_NAME (
                id INTEGER PRIMARY KEY,
                chat_id INTEGER NOT NULL,
                content TEXT NOT NULL
            );
        """.trimIndent())
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $CHATS_TABLE_NAME")
        db?.execSQL("DROP TABLE IF EXISTS $MESSAGES_TABLE_NAME")
        onCreate((db))
    }

    companion object {
        const val DATABASE_NAME = "TheCrypt"
        const val DATABASE_VERSION = 1
        const val CHATS_TABLE_NAME = "chats"
        const val MESSAGES_TABLE_NAME = "messages"
    }
}