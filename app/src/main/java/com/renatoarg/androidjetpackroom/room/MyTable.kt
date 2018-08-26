package com.renatoarg.androidjetpackroom.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey

// defines the table name = "tbEvent" and creates an index for "name"
@Entity(tableName = "myTable", indices = [Index("name", unique = true)])
data class User(
       @PrimaryKey (autoGenerate = true)
       var id: Long = 0,
       var name: String = "",
       @ColumnInfo(name = "info")
       var description: String = ""
)