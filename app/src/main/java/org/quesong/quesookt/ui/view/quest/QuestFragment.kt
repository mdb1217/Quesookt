package org.quesong.quesookt.ui.view.quest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import org.quesong.core.base.BindingFragment
import org.quesong.quesookt.R
import org.quesong.quesookt.databinding.FragmentQuestBinding
import org.quesong.quesookt.ui.view.quest.adapter.QuestAdapter
import org.quesong.quesookt.ui.view.quest.model.QuestInfoData
import org.quesong.quesookt.ui.view.quest.model.ResponseQuestData

class QuestFragment : BindingFragment<FragmentQuestBinding>(R.layout.fragment_quest) {
    private lateinit var questAdapter: QuestAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initQuestAdapter()
    }

    private fun initQuestAdapter() {
        questAdapter = QuestAdapter()
        binding.rvQuest.adapter = questAdapter

//        questAdapter.questList.addAll(
//            listOf(
//                QuestInfoData("타이틀", "설명", "3", "시작하기", 0, "이미지"),
//                QuestInfoData("타이틀", "설명", "3", "시작하기", 0, "이미지"),
//                QuestInfoData("타이틀", "설명", "3", "진행중", 50, "이미지"),
//                QuestInfoData("타이틀", "설명", "3", "진행중", 50, "이미지")
//            )
//        )

        questAdapter.questList.addAll(getQuestData())

        initQuestClickListener()
    }

    private fun getQuestData() : List<QuestInfoData> {
        FirebaseDatabase.getInstance().getReference("QuestData")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    Log.d("take-please", dataSnapshot.value.toString())
                    val responseQuestData : Any? = dataSnapshot.value
                    val group: ResponseQuestData? = dataSnapshot.getValue(ResponseQuestData::class.java)
                    //val group: ResponseQuestData? =
                    //    dataSnapshot.getValue(ResponseQuestData::class.java)

                    //각각의 값 받아오기 get어쩌구 함수들은 Together_group_list.class에서 지정한것
                    //Log.d("survive", "im a live")
                    //Log.d("test-server", group!!.user[0].title) //user는 어디서남?
                    Log.d("last-test", group!!.toString())
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    Log.e("what", "help me"); // 에러문 출력
                }
            })
        return listOf(QuestInfoData("타이틀", "설명", "3", "진행중", 50, "이미지"))

    }

    private fun initQuestClickListener() {
        questAdapter.setQuestClickListener {
            val intent = Intent(requireContext(), QuestDetailActivity::class.java)
            intent.putExtra("title", it)
            startActivity(intent)
        }
    }
}