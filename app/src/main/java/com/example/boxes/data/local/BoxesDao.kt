package com.example.boxes.data.local

import androidx.room.*
import com.example.boxes.data.local.entities.BoxesListEntity

@Dao
interface BoxesDao {

    @Query("SELECT FROM boxes_lists WHERE email =:mail)")
    suspend fun getBoxesByMail(mail: String): BoxesListEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert( boxesListEntity: BoxesListEntity)

    @Delete
    suspend fun delete( boxesListEntity: BoxesListEntity)

}