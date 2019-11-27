package com.jaimerson.thecyrpt

import android.content.Context

class DatabaseThing {
    companion object {
        private var databaseHelper: DatabaseHelper? = null

        fun initialize(context: Context){
            this.databaseHelper = DatabaseHelper(context)
        }

        fun savePrivateKey(username: String, privateKey: String){
            val connection = this.databaseHelper!!.writableDatabase

            connection.execSQL("""
                INSERT INTO ${DatabaseHelper.SETTINGS_TABLE_NAME} (username, private_key)
                VALUES ("$username", "$privateKey");
            """.trimIndent())

            connection.close()
        }
    }
}