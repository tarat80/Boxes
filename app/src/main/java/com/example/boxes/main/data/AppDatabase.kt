package com.example.boxes.main.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.boxes.main.data.entities.AccountBoxSettingDbEntity
import com.example.boxes.main.data.entities.AccountDbEntity
import com.example.boxes.main.data.entities.BoxDbEntity


@Database(
    version = 1,
    entities = [
        AccountDbEntity::class,
        BoxDbEntity::class,
        AccountBoxSettingDbEntity::class
    ]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getAccountsDao(): AccountsDao

    abstract fun getBoxesDao(): BoxesDao

}