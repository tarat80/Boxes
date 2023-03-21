package com.example.boxes.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.boxes.boxesscreenfeature.domain.model.Box
import com.example.boxes.boxesscreenfeature.presentation.BoxState

@Entity(
    tableName = "boxes_lists",
    indices = [Index("email", unique = true)]
)
data class BoxesListEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "email", collate = ColumnInfo.NOCASE) val mail: String,
    val boxes: List<Box>,

) {
    interface Mapper<T> {
        fun map(
            mail: String,
            boxes: List<Box>
        ): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(mail, boxes)

}

class BoxesListEntityMapper : BoxesListEntity.Mapper<BoxState> {
    override fun map(
        mail: String,
        boxes: List<Box>
    ): BoxState = BoxState(mail, boxes)
}

fun defaultMake(mMail: String): BoxesListEntity {
    return BoxesListEntity(id=0, mail =mMail, listOf(Box(),Box(),Box(),Box(),Box(),Box())
    )
}