package org.quesong.quesookt.ui.view.quest

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import org.quesong.core.base.BindingActivity
import org.quesong.core.util.DialogUtil
import org.quesong.core.util.extension.setImgFilter20
import org.quesong.quesookt.R
import org.quesong.quesookt.databinding.ActivityQuestDetailBinding
import org.quesong.quesookt.databinding.LayoutQuesooktDialogBinding
import org.quesong.quesookt.ui.view.quest.model.QuestDetailInfoData

class QuestDetailActivity :
    BindingActivity<ActivityQuestDetailBinding>(R.layout.activity_quest_detail) {
    private lateinit var trashDialog: Dialog
    private lateinit var trashDialogBinding: LayoutQuesooktDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initQuestDetailInfoData()
        initBackBtnClickListener()
        initTrashBtnClickListener()
        initStateBtnClickListener()
        initDialogDataBinding()
        initDialog()
        setDialog()
        initClickEvent()
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

    private fun initStateBtnClickListener() {
        with(binding) {
            btnQuestState.setOnClickListener {
                when(btnQuestState.text) {
                    getString(R.string.start) -> {
                        pbQuest.progress = 50
                        btnQuestState.text = getString(R.string.finish_quest)
                    }
                    getString(R.string.finish_quest) -> {
                        //항목 삭제
                        finish()
                    }
                }
            }
        }
    }

    private fun initBackBtnClickListener() {
        binding.ivArrowBack.setOnClickListener {
            finish()
        }
    }

    private fun initTrashBtnClickListener() {
        binding.ivTrash.setOnClickListener {
            trashDialog.show()
        }
    }

    private fun initClickEvent() {
        trashDialogBinding.apply {
            clNext.setOnClickListener {
                trashDialog.dismiss()
                finish()
            }
            clQuit.setOnClickListener {
                trashDialog.dismiss()
            }
        }
    }

    private fun initDialog() {
        trashDialog = DialogUtil.makeDialog(this)

        DialogUtil.setDialog(trashDialog, trashDialogBinding.root)
    }

    private fun initDialogDataBinding() {
        trashDialogBinding = DataBindingUtil.inflate(
            LayoutInflater.from(this),
            R.layout.layout_quesookt_dialog,
            null,
            false
        )
    }

    private fun setDialog() {
        trashDialogBinding.apply {
            tvNext.text = getString(R.string.accept)
            tvContent.text = getString(R.string.delete_desc)
            tvTitle.text = getString(R.string.delete_sure)
        }
    }

    companion object {
        const val START = 0
        const val ING = 1
    }
}