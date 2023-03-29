package com.example.boxes.boxesscreenfeature.data

import androidx.core.graphics.toColorInt
import com.example.boxes.boxesscreenfeature.domain.model.Box
import com.example.boxes.main.data.BoxesDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BoxesRepositoryImpl @Inject constructor(
     private val boxesDao: BoxesDao
) : BoxesRepository {

     override suspend fun getBoxes(id: Long): List<Box> {
          return boxesDao.getBoxesAndSettings(id)
               .map {
                    val boxEntity = it.key
                    val settingsEntity = it.value
                    Box(
                         colorName = boxEntity.colorName,
                         colorValue = boxEntity.colorValue.toColorInt(),
                         isActive = settingsEntity == null || settingsEntity.isActive
                    )
               }
     }
}