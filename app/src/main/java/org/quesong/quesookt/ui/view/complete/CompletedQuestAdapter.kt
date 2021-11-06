package org.quesong.quesookt.ui.view.complete

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.quesong.quesookt.databinding.ItemCompletedQuestBinding
import org.quesong.quesookt.ui.view.complete.model.CompletedInfoData

class CompletedQuestAdapter : RecyclerView.Adapter<CompletedQuestAdapter.CompletedQuestViewHolder>() {
    private val _completedList = mutableListOf<CompletedInfoData>()

    var completedList: MutableList<CompletedInfoData> = _completedList
        set(value){
            _completedList.clear()
            _completedList.addAll(value)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompletedQuestViewHolder {

        val binding = ItemCompletedQuestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CompletedQuestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CompletedQuestViewHolder, position: Int) {
        holder.onBind(_completedList[position])
    }

    override fun getItemCount(): Int = completedList.size
    class CompletedQuestViewHolder(private val binding: ItemCompletedQuestBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(completedInfoData: CompletedInfoData){
            binding.completedInfoData = completedInfoData
        }
    }
}