package com.example.boxes.main.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.boxes.boxesscreenfeature.domain.model.Box
import com.example.boxes.boxesscreenfeature.presentation.BoxState

@Entity(
    tableName = "boxes"
)
data class BoxesListEntity(
    @PrimaryKey
    @ColumnInfo(name = "email", collate = ColumnInfo.NOCASE) val email: String,
    val boxes: List<Box>
) {
    interface Mapper<T> {
        fun map(
            mail: String,
            boxes: List<Box>
        ): T
    }
    fun <T> map(mapper: Mapper<T>): T = mapper.map(email, boxes)
}

class BoxesListEntityMapper : BoxesListEntity.Mapper<BoxState> {
    override fun map(
        mail: String,
        boxes: List<Box>
    ): BoxState = BoxState(mail, boxes)
}
fun defaultMake(mMail: String): BoxesListEntity {
    return BoxesListEntity(
        email =mMail, List(6){Box()}
    )
}