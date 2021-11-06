package org.quesong.quesookt.ui.view.quest

import android.os.Bundle
import org.quesong.core.base.BindingActivity
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
        // intent.getStringExtra("title") -> 서버로 보내서 데이터 받아오기
        binding.questDetailInfoData = QuestDetailInfoData(
            "이미지", intent.getStringExtra("title").toString(),
            "시작하기", "갸아아아아아아앙", "팁입니다....", isStarted = false
        )
    }

    private fun initBackBtnClickListener() {
        binding.btnQuestState.setOnClickListener {
            finish()
        }
    }
}