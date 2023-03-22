package com.example.boxes.di

import android.app.Application
import androidx.room.Room
import com.example.boxes.main.data.local.Converters
import com.example.boxes.main.data.local.UsersAndBoxesDatabase
import com.example.boxes.utils.GsonParser
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideDataBase(app: Application) : UsersAndBoxesDatabase {
        return Room.databaseBuilder(app,
                 UsersAndBoxesDatabase::class.java,
                 name="users.db")
            .addTypeConverter(Converters(GsonParser(Gson())))
            .build()
    }
}