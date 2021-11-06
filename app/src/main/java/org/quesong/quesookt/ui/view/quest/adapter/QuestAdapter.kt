package org.quesong.quesookt.ui.view.quest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.quesong.quesookt.databinding.ItemQuestBinding
import org.quesong.quesookt.ui.view.quest.model.QuestInfoData

class QuestAdapter : RecyclerView.Adapter<QuestAdapter.QuestViewHolder>() {
    private val _questList = mutableListOf<QuestInfoData>()

    var questList: MutableList<QuestInfoData> = _questList
        set(value) {
            _questList.clear()
            _questList.addAll(value)
            notifyDataSetChanged()
        }

    private var questClickListener: ((String) -> Unit)? = null

    fun setQuestClickListener(listener: (String) -> Unit) {
        questClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestViewHolder {
        val binding = ItemQuestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuestViewHolder, position: Int) {
        holder.onBind(_questList[position])
    }

    override fun getItemCount(): Int = questList.size

    inner class QuestViewHolder(
        private val binding: ItemQuestBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(questInfoData: QuestInfoData) {
            binding.questInfoData = questInfoData
            binding.clQuest.setOnClickListener {
                questClickListener?.invoke(questInfoData.title)
            }
        }
    }
}