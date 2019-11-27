package com.jaimerson.thecyrpt.data

import com.jaimerson.thecyrpt.User
import com.jaimerson.thecyrpt.WebClient
import com.jaimerson.thecyrpt.data.model.LoggedInUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.lang.Exception

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String,
              password: String,
              onSuccess: (Result.Success<LoggedInUser>) -> Unit = {},
              onFailure: (Result.Error) -> Unit = {}
    ) {
        WebClient().chatService().login(username, password).enqueue(object:Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if(response.isSuccessful()){
                    val user = LoggedInUser(username, username)
                    onSuccess(Result.Success(user))
                }else{
                    onFailure(Result.Error(IOException(response.body().toString())))
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                onFailure(Result.Error(IOException("Error logging in")))
            }
        })
    }

    fun logout() {
        // TODO: revoke authentication
    }
}

