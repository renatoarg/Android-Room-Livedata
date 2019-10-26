package com.renatoarg.androidjetpackroom.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

// defines the table name = "tbEvent" and creates an index for "name"
@Entity(tableName = "myTable", indices = [Index("name", unique = true)])
data class User(
       @PrimaryKey (autoGenerate = true)
       var id: Long = 0,
       var name: String = "",
       @ColumnInfo(name = "info")
       var description: String = ""
)