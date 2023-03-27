package com.example.boxes.main.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import com.example.boxes.main.data.entities.AccountBoxSettingDbEntity
import com.example.boxes.main.data.entities.BoxDbEntity

@Dao
interface BoxesDao {

    @Query("SELECT * " +
            "FROM boxes " +
            "LEFT JOIN accounts_boxes_settings " +
            "  ON boxes.id = accounts_boxes_settings.box_id AND accounts_boxes_settings.account_id = :accountId")
    fun getBoxesAndSettings(accountId: Long): Flow<Map<BoxDbEntity, AccountBoxSettingDbEntity?>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setActiveFlagForBox(accountBoxSetting: AccountBoxSettingDbEntity)

}
