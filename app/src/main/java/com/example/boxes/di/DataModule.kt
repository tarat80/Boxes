package com.example.boxes.di

import android.app.Application
import androidx.room.Room
import com.example.boxes.main.data.AccountsDao
import com.example.boxes.main.data.AppDatabase
import com.example.boxes.main.data.BoxesDao
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
    fun provideDataBase(app : Application) : AppDatabase{
        return Room.databaseBuilder(
            app, AppDatabase::class.java, "database.db")
            .createFromAsset("initial_database.db")
            .build()
    }
    @Provides
    @Singleton
    fun provideBoxesDao(appDatabase: AppDatabase): BoxesDao {
        return appDatabase.getBoxesDao()
    }
    @Provides
    @Singleton
    fun provideAccountsDao(appDatabase: AppDatabase): AccountsDao {
        return appDatabase.getAccountsDao()
    }
}