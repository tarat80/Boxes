package com.example.boxes.main.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.boxes.boxesscreenfeature.domain.model.Box
import com.example.boxes.utils.JsonParser
import com.google.gson.reflect.TypeToken


@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromJson(json: String): List<Box> {
        return jsonParser.fromJson<ArrayList<Box>>(
            json,
            object : TypeToken<ArrayList<Box>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toJson(boxes: List<Box>): String {
        return jsonParser.toJson(
            boxes,
            object : TypeToken<ArrayList<Box>>(){}.type
        ) ?: "[]"
    }
}