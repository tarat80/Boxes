package com.example.boxes.di

import com.example.boxes.loginfeature.data.RepositoryLoginImpl
import com.example.boxes.loginfeature.domain.RepositoryLogin
import com.example.boxes.registerfeature.data.RepositoryRegisterImpl
import com.example.boxes.registerfeature.domain.RepositoryRegister
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface BindModule {
    @Binds
    fun bindRepositoryLogin(
        repositoryLoginImpl: RepositoryLoginImpl
    ) : RepositoryLogin

    @Binds
    fun bindRepositoryRegister(
        repositoryRegisterImpl: RepositoryRegisterImpl
    ) : RepositoryRegister
}