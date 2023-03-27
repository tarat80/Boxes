package com.example.boxes.loginfeature.data

import com.example.boxes.loginfeature.domain.RepositoryLogin
import com.example.boxes.loginfeature.domain.model.Resource
import com.example.boxes.main.data.AppDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryLoginImpl @Inject constructor(
    appDatabase: AppDatabase
) : RepositoryLogin {

    private val dao = appDatabase.getAccountsDao()

    override suspend fun login(email: String, password: String): Flow<Resource<Long>> {
        return flow {
            val temp = dao.findByEmail(email)
            if (temp == null) {
                emit(Resource.Error(message = "there is no such account", data = -1))
                return@flow
            }
            if (temp.password != password) emit(
                Resource.Error(message = "wrong password", data = -1)
            )
            else {
                emit(Resource.Success(temp.id))
            }
        }
    }
}