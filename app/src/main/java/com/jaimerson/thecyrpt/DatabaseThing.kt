package com.jaimerson.thecyrpt

import android.content.Context

class DatabaseThing {
    companion object {
        private var databaseHelper: DatabaseHelper? = null

        fun initialize(context: Context){
            this.databaseHelper = DatabaseHelper(context)
        }

        fun saveSettings(username: String, privateKey: String, publicKey: String){
            val connection = this.databaseHelper!!.writableDatabase

            connection.execSQL("""
                INSERT INTO ${DatabaseHelper.SETTINGS_TABLE_NAME} (username, private_key, public_key)
                VALUES ("$username", "$privateKey", "$publicKey");
            """.trimIndent())

            connection.close()
        }
    }
}