package com.example.boxes.registerfeature.data

import com.example.boxes.loginfeature.domain.model.Resource
import com.example.boxes.main.data.AppDatabase
import com.example.boxes.main.data.entities.AccountDbEntity
import com.example.boxes.registerfeature.domain.RepositoryRegister
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryRegisterImpl @Inject constructor(
    appDatabase: AppDatabase
): RepositoryRegister{

    private val dao = appDatabase.getAccountsDao()

    override suspend fun register(email: String, password: String): Flow<Resource<Long>> {
        return flow {
            var temp = dao.findByEmail(email)
            if (temp != null) {
                emit(Resource.Error(message = "email already used", data = -1))
                return@flow
            }
            else {
                dao.createAccount(AccountDbEntity(
                    id = 0,
                    email = email,
                    username = "username",
                    password = password,
                    createdAt = System.currentTimeMillis()
                ))
                temp = dao.findByEmail(email)
                emit(Resource.Success(temp!!.id))
            }
        }
    }
}