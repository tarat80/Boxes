package com.example.boxes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.boxes.data.local.entities.BoxesListEntity
import com.example.boxes.data.local.entities.UserEntity

@Database(
    entities = [
        BoxesListEntity::class,
        UserEntity::class
    ],
    version = 1

)
@TypeConverters(Converters::class)
abstract class UsersAndBoxesDatabase : RoomDatabase() {

    abstract fun getUsersDao(): UsersDao

    abstract fun getBoxesDao(): BoxesDao
}