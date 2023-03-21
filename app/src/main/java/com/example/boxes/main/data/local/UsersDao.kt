package com.example.boxes.main.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.boxes.main.data.local.entities.UserEntity
import com.example.boxes.main.data.local.entities.UserTuple

@Dao
interface UsersDao {
    @Query("SELECT password FROM accounts WHERE email = :mMail")
    suspend fun getPassword(mMail: String): UserTuple?

    @Insert(entity = UserEntity::class)
    suspend fun createAccount(userEntity: UserEntity)
}