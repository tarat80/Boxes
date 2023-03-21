package com.example.boxes.di

import android.app.Application
import androidx.room.Room
import com.example.boxes.main.data.local.UsersAndBoxesDatabase
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    fun provideDataBase(app: Application) : UsersAndBoxesDatabase {
        return Room.databaseBuilder(app,
                 UsersAndBoxesDatabase::class.java,
                 name="users.db")
            .build()
    }
}