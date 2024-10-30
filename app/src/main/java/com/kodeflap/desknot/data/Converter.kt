package com.kodeflap.desknot.data

import androidx.room.TypeConverter
import com.kodeflap.desknot.domain.Priority

class Converter {

    @TypeConverter
    fun fromPriority(priority: Priority): String {
        return priority.name
    }

    @TypeConverter
    fun toPriority(priority: String): Priority {
        return Priority.valueOf(priority)
    }
}