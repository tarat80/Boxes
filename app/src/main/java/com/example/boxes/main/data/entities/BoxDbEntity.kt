package com.example.boxes.main.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "boxes"
)
data class BoxDbEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "color_name") val colorName: String,
    @ColumnInfo(name = "color_value") val colorValue: String
)
