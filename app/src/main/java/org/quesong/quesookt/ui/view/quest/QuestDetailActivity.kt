package org.quesong.quesookt.ui.view.quest

import android.os.Bundle
import org.quesong.core.base.BindingActivity
import org.quesong.core.util.extension.setImgFilter20
import org.quesong.quesookt.R
import org.quesong.quesookt.databinding.ActivityQuestDetailBinding
import org.quesong.quesookt.ui.view.quest.model.QuestDetailInfoData

class QuestDetailActivity :
    BindingActivity<ActivityQuestDetailBinding>(R.layout.activity_quest_detail) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initQuestDetailInfoData()
        initBackBtnClickListener()
    }

    private fun initQuestDetailInfoData() {
        with(intent) {
            with(binding) {
                questDetailInfoData = QuestDetailInfoData(
                    getStringExtra("imgUrl").toString(), getStringExtra("title").toString(),
                    getStringExtra("state").toString(), getStringExtra("description").toString(),
                    getStringExtra("tip").toString(), 0
                )
                ivQuest.setImgFilter20()
                when(getIntExtra("isStarted", START)) {
                    START -> {
                        pbQuest.progress = 0
                        btnQuestState.text = "시작하기"
                    }
                    ING -> {
                        pbQuest.progress = 50
                        btnQuestState.text = "완료하기"
                    }
                    else -> {

                    }
                }
            }
        }
    }

    //시작 완료 -> 처리하기
    private fun initBackBtnClickListener() {
        binding.btnQuestState.setOnClickListener {
            finish()
        }
    }

    companion object {
        const val START = 0
        const val ING = 1
    }
}