package com.example.boxes.main.data.local.entities

import androidx.room.ColumnInfo

data class UserTuple(
    @ColumnInfo(name = "password") val password: String?
)