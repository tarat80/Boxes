package com.example.boxes.main.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
   tableName = "accounts",
   indices = [Index("email", unique = true)]
)
data class UserEntity(
   @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long,
   @ColumnInfo(name = "email", collate = ColumnInfo.NOCASE) val email: String,
   @ColumnInfo(name = "name") val userName: String,
   @ColumnInfo(name = "password") val password: String,
   @ColumnInfo(name = "created_at") val createdAt: Long? = null
) {
   interface Mapper<T> {
      fun map(
         mail: String,
         userName: String,
         password: String,
         createdAt: Long?
      ): T
   }

   fun <T> map(mapper: Mapper<T>): T = mapper.map(email, userName, password, createdAt)
}
