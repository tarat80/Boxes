package com.example.boxes.main.data.local

import androidx.room.*
import com.example.boxes.main.data.local.entities.BoxesListEntity

@Dao
interface BoxesDao {

    @Query("SELECT * FROM boxes WHERE email =:email")
    suspend fun getBoxes(email: String): BoxesListEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert( boxesListEntity: BoxesListEntity)

    @Delete
    suspend fun delete( boxesListEntity: BoxesListEntity)

}