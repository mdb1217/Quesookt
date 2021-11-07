package org.quesong.quesookt.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quest_data_table")
data class QuestData(
    @PrimaryKey(autoGenerate = true)
    val id: Long?,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "explanation")
    val explanation: String,

    @ColumnInfo(name = "status")
    val status: Int,

    @ColumnInfo(name = "date")
    val date: String,

    @ColumnInfo(name = "complete")
    val complete: Boolean
)