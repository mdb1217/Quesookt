package org.quesong.quesookt.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.quesong.quesookt.data.local.model.QuestData
import org.quesong.quesookt.domain.QuestRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val questRepo: QuestRepository) :
    ViewModel() {
    private val _questList = MutableLiveData<List<QuestData>>()
    val questList: LiveData<List<QuestData>>
        get() = _questList

    private val _completeQuestList = MutableLiveData<List<QuestData>>()
    val completeQuestList: LiveData<List<QuestData>>
        get() = _completeQuestList

    fun insertQuestData(questData: QuestData) {
        runCatching { questRepo.insert(questData) }
            .onSuccess {

            }
            .onFailure {
                it.printStackTrace()
            }
    }

    fun getCompleteQuestRepo() {
        runCatching { questRepo.getCompleteQuest() }
            .onSuccess {
                _completeQuestList.postValue(it)
            }
            .onFailure {
                it.printStackTrace()
            }
    }

    fun updateComplete(isCompleted: Int, id: Long) {
        runCatching { questRepo.updateComplete(isCompleted, id) }
            .onSuccess {

            }
            .onFailure {
                it.printStackTrace()
            }
    }

    fun deleteQuestData(questData: QuestData) {
        runCatching { questRepo.delete(questData) }
            .onSuccess {

            }
            .onFailure {
                it.printStackTrace()
            }
    }

    fun getAll() {
        runCatching { questRepo.getAll() }
            .onSuccess {
                _questList.postValue(it)
            }
            .onFailure {
                it.printStackTrace()
            }
    }
}