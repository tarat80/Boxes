package com.example.boxes.main.data.local

import com.example.boxes.boxesscreenfeature.domain.BoxesListRepository
import com.example.boxes.boxesscreenfeature.presentation.BoxState
import com.example.boxes.main.data.local.entities.BoxesListEntityMapper
import com.example.boxes.main.data.local.entities.defaultMake
import javax.inject.Inject

class BoxesListRepositoryImpl @Inject constructor(
    usersAndBoxesDatabase : UsersAndBoxesDatabase,
    private val boxesListEntityMapper: BoxesListEntityMapper
): BoxesListRepository {
    private val dao = usersAndBoxesDatabase.getBoxesDao()

    override suspend fun getBoxesByMail(mail: String): BoxState {

         var temp = dao.getBoxes(mail)
         if (temp != null) return temp.map(boxesListEntityMapper)

         temp = defaultMake(mail)
         dao.insert(temp)
         return temp.map(boxesListEntityMapper)
     }
}
