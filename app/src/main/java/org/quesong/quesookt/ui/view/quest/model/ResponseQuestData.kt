package org.quesong.quesookt.ui.view.quest.model

data class ResponseQuestData(
    val questData: ArrayList<IndexData>,
){
    data class IndexData(
        val questFullData: QuestFullData
    ){
        data class QuestFullData (
            val description: String,
            val imgUrl: String,
            val isStarted: Boolean,
            val people: Int,
            val progress: Int,
            val state: String,
            val tip: String,
            val title: String
        )
    }
}
