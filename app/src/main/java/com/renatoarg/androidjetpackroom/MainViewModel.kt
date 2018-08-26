package com.renatoarg.androidjetpackroom

import android.arch.lifecycle.*
import com.renatoarg.androidjetpackroom.room.User

class MainViewModel : ViewModel(), LifecycleObserver {

    // creates reference to the repository
    private val mRepository : MainRepository = MainRepository(AppApplication.instance)

    var mWords: LiveData<List<User>>

    init { mWords = mRepository.getAllWords() }

    fun getAllUsers() : LiveData<List<User>>  { return mWords }

    fun addUser(name: String, desc: String) { mRepository.insertWord(name, desc) }

    fun deleteUser(user: User) { mRepository.deleteUser(user)}

}