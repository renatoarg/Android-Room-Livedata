package com.renatoarg.androidjetpackroom.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE) // replaces primary keys
    fun insert(user: User): Long // returns the id of the registry

    @Update
    fun update(user: User): Int // returns the qty of lines affected by the update

    @Delete
    fun delete(vararg user: User): Int // returns te qty of lines affected by the delete

    @Query("SELECT * FROM myTable WHERE name LIKE :name ORDER BY name")
    fun getAllUsers(name: String = "%"): LiveData<List<User>>

    @Query("SELECT * FROM myTable WHERE id = :id")
    fun eventsById(id: Long): User?

}