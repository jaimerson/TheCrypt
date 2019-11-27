package com.jaimerson.thecyrpt.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jaimerson.thecyrpt.data.LoginRepository
import com.jaimerson.thecyrpt.data.Result

import com.jaimerson.thecyrpt.R

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login(username: String, password: String) {
        // can be launched in a separate asynchronous job
        loginRepository.login(username, password, onSuccess = { result ->
            _loginResult.value =
                LoginResult(success = LoggedInUserView(displayName = result.data.displayName))
        }, onFailure = { error ->
            _loginResult.value = LoginResult(error = error.exception.message)
        })
    }

    fun signUp(username: String, password: String) {
        // can be launched in a separate asynchronous job
        loginRepository.signUp(username, password, onSuccess = { result ->
            _loginResult.value =
                LoginResult(success = LoggedInUserView(displayName = result.data.displayName))
        }, onFailure = { error ->
            _loginResult.value = LoginResult(error = error.exception.message)
        })
    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return username.isNotBlank()
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}
