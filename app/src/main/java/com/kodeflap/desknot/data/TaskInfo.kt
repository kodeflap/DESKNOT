package com.kodeflap.desknot.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kodeflap.desknot.domain.Priority
import kotlinx.parcelize.Parcelize

@Entity(tableName = "task")
@Parcelize
data class TaskInfo(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var priority: Priority,
    var description: String
): Parcelable