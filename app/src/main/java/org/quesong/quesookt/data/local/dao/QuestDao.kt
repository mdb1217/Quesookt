package org.quesong.quesookt.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import org.quesong.quesookt.data.local.model.QuestData

@Dao
interface QuestDao {
    @Query("SELECT * FROM quest_data_table")
    fun getAll(): List<QuestData>

    @Query("SELECT * FROM quest_data_table WHERE complete = 1")
    fun getCompleteQuest(): List<QuestData>

    @Query("UPDATE quest_data_table SET complete = :isCompleted WHERE id =:id")
    fun updateComplete(isCompleted: Int, id: Long)

    @Insert
    fun insert(questData: QuestData)

    @Delete
    fun delete(questData: QuestData)
}