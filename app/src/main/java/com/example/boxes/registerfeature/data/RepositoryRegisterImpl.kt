package com.example.boxes.registerfeature.data

import com.example.boxes.loginfeature.domain.model.Resource
import com.example.boxes.main.data.AccountsDao
import com.example.boxes.main.data.entities.AccountDbEntity
import com.example.boxes.registerfeature.domain.RepositoryRegister
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryRegisterImpl @Inject constructor(
    private val accountsDao: AccountsDao
): RepositoryRegister{

    override suspend fun register(email: String, password: String): Flow<Resource<Long>> {
        return flow {
            var temp = accountsDao.findByEmail(email)
            if (temp != null) {
                emit(Resource.Error(message = "email already used", data = -1))
                return@flow
            }
            else {
                accountsDao.createAccount(AccountDbEntity(
                    id = 0,
                    email = email,
                    username = "username",
                    password = password,
                    createdAt = System.currentTimeMillis()
                ))
                temp = accountsDao.findByEmail(email)
                emit(Resource.Success(temp!!.id))
            }
        }
    }
}