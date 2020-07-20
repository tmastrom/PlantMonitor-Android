package com.example.plantmonitor.ui.auth

import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.plantmonitor.data.repositories.UserRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AuthViewModel(
    private val repository: UserRepository
) : ViewModel() {

    //email and password for the input
    var email: String? = null
    var password: String? = null


    //auth listener
    var authListener: AuthListener? = null

    //disposable to dispose of the Completable
    private val disposables = CompositeDisposable()

    val user by lazy {
        repository.currentUser()
    }

    //perform the login
    fun login() {

        //validate email and password
        // Todo: Use a validator class for testing
        if (!SignInValidator.isValidEmail(email) && !SignInValidator.isValidPassword(password)) {
            authListener?.onFailure("Invalid email or password\n email: "+ email + "\npassword: "+ password)
            return
        }

        //authentication started
        authListener?.onStarted()

        //call login from repository to perform the authentication
        val disposable = repository.login(email!!, password!!)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                authListener?.onSuccess()
            }, {
                authListener?.onFailure(it.message!!)
            })
        disposables.add(disposable)
    }

    //perform the signup
    fun signup() {
        if (SignInValidator.isValidEmail(email) || SignInValidator.isValidPassword(password)) {
            authListener?.onFailure("Please input all values")
            return
        }
        authListener?.onStarted()
        val disposable = repository.register(email!!, password!!)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                authListener?.onSuccess()
            }, {
                authListener?.onFailure(it.message!!)
            })
        disposables.add(disposable)
    }


    //disposing the disposables
    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}