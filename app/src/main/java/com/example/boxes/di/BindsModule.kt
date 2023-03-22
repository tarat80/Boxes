package com.example.boxes.di

import com.example.boxes.loginfeature.domain.LoginRepository
import com.example.boxes.main.data.local.LoginRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface BindsModule {

   @Binds
    fun bindLoginRepository(
        loginRepositoryImpl:LoginRepositoryImpl
    ): LoginRepository
}