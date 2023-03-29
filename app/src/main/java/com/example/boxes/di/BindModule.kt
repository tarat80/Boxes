package com.example.boxes.di

import com.example.boxes.boxesscreenfeature.data.BoxesRepository
import com.example.boxes.boxesscreenfeature.data.BoxesRepositoryImpl
import com.example.boxes.loginfeature.data.RepositoryLoginImpl
import com.example.boxes.loginfeature.domain.RepositoryLogin
import com.example.boxes.registerfeature.data.RepositoryRegisterImpl
import com.example.boxes.registerfeature.domain.RepositoryRegister
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface BindModule {
    @Binds
    @Singleton
    fun bindRepositoryLogin(
        repositoryLoginImpl: RepositoryLoginImpl
    ) : RepositoryLogin

    @Binds
    @Singleton
    fun bindRepositoryRegister(
        repositoryRegisterImpl: RepositoryRegisterImpl
    ) : RepositoryRegister

    @Binds
    @Singleton
    fun bindBoxesRepository(
        boxesRepositoryImpl: BoxesRepositoryImpl
    ) : BoxesRepository
}