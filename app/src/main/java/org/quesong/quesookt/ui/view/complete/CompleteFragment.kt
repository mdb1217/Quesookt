package org.quesong.quesookt.ui.view.complete

import android.os.Bundle
import android.view.View
import org.quesong.core.base.BindingFragment
import org.quesong.quesookt.R
import org.quesong.quesookt.databinding.FragmentCompleteBinding
import org.quesong.quesookt.ui.view.complete.model.CompletedInfoData

class CompleteFragment : BindingFragment<FragmentCompleteBinding>(R.layout.fragment_complete) {
    private lateinit var completedQuestAdapter: CompletedQuestAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCompletedAdapter()
    }

    private fun initCompletedAdapter(){
        completedQuestAdapter = CompletedQuestAdapter()
        binding.rvCompleted.adapter = completedQuestAdapter

        completedQuestAdapter.completedList.addAll(
            listOf(CompletedInfoData("타이틀","2000/01/01",""),
                CompletedInfoData("타이틀","2000/01/01",""),
                CompletedInfoData("타이틀","2000/01/01",""),
                CompletedInfoData("타이틀","2000/01/01",""))
        )
    }
}