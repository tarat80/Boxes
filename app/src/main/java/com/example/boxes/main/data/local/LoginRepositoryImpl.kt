package com.example.boxes.main.data.local

import com.example.boxes.loginfeature.domain.LoginRepository
import com.example.boxes.loginfeature.domain.model.User
import com.example.boxes.main.data.local.entities.UserEntity
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val usersAndBoxesDatabase : UsersAndBoxesDatabase,
    private val userMapper: UserMapper
) : LoginRepository {
    private val dao =usersAndBoxesDatabase.getUsersDao()
    override suspend fun checkLogData() {
        TODO("Not yet implemented")
    }

    override suspend fun register(user: User) {
       dao.createAccount(userEntity = user.map(userMapper) )
    }
}

class UserMapper @Inject constructor(): User.Mapper<UserEntity> {
    override fun map(
        mail: String,
        name: String,
        password: String,
        repeatedPassword: String
    ): UserEntity = UserEntity(id = 0, email = mail,
        userName = name,password= password)
}