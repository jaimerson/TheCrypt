package com.jaimerson.thecyrpt.data

import com.jaimerson.thecyrpt.data.model.LoggedInUser

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class LoginRepository(val dataSource: LoginDataSource) {

    // in-memory cache of the loggedInUser object
    var user: LoggedInUser? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
        user = null
    }

    fun logout() {
        user = null
        dataSource.logout()
    }

    fun login(username: String,
              password: String,
              onSuccess: (Result.Success<LoggedInUser>) -> Unit = {},
              onFailure: (Result.Error) -> Unit = {}
    ) {
        dataSource.login(username, password, onSuccess = { result ->
            setLoggedInUser(result.data)
            onSuccess(result)
        }, onFailure = onFailure)
    }

    private fun setLoggedInUser(loggedInUser: LoggedInUser) {
        this.user = loggedInUser
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }
}
