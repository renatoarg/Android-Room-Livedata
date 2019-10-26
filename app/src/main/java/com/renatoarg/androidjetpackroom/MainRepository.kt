package com.renatoarg.androidjetpackroom

import androidx.lifecycle.LiveData
import com.renatoarg.androidjetpackroom.room.AppDatabase
import com.renatoarg.androidjetpackroom.room.User
import com.renatoarg.androidjetpackroom.room.UserDao
import org.jetbrains.anko.doAsync


class MainRepository(application: AppApplication) {

    private val userDao: UserDao
    private val mWords: LiveData<List<User>>

    init {
        val db = AppDatabase.getInstance(application.applicationContext)
        userDao = db!!.userDao()
        mWords = userDao.getAllUsers()
    }

    fun getAllWords(): LiveData<List<User>> {
        return mWords
    }

    fun insertWord(name: String, desc: String) {
        doAsync {
            var u1 = User(0, name, desc)
            userDao.insert(u1)
        }
    }

    fun deleteUser(user: User) {
        doAsync {
            userDao.delete(user)
        }
    }

}