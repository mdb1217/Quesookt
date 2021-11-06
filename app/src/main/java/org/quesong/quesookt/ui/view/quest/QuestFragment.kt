package org.quesong.quesookt.ui.view.quest

import android.content.Intent
import android.os.Bundle
import android.view.View
import org.quesong.core.base.BindingFragment
import org.quesong.quesookt.R
import org.quesong.quesookt.databinding.FragmentQuestBinding
import org.quesong.quesookt.ui.view.quest.adapter.QuestAdapter
import org.quesong.quesookt.ui.view.quest.model.QuestInfoData

class QuestFragment : BindingFragment<FragmentQuestBinding>(R.layout.fragment_quest) {
    private lateinit var questAdapter: QuestAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initQuestAdapter()
    }

    private fun initQuestAdapter() {
        questAdapter = QuestAdapter()
        binding.rvQuest.adapter = questAdapter

        questAdapter.questList.addAll(
            listOf(
                QuestInfoData("타이틀", "설명", "3", "시작하기", 0, "이미지"),
                QuestInfoData("타이틀", "설명", "3", "시작하기", 0, "이미지"),
                QuestInfoData("타이틀", "설명", "3", "진행중", 50, "이미지"),
                QuestInfoData("타이틀", "설명", "3", "진행중", 50, "이미지")
            )
        )
        initQuestClickListener()
    }

    private fun initQuestClickListener() {
        questAdapter.setQuestClickListener {
            val intent = Intent(requireContext(), QuestDetailActivity::class.java)
            intent.putExtra("title", it)
            startActivity(intent)
        }
    }
}