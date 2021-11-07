package org.quesong.quesookt.ui.view.onboard

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.quesong.core.base.BindingFragment
import org.quesong.quesookt.R
import org.quesong.quesookt.databinding.FragmentResultBinding
import org.quesong.quesookt.ui.view.MainActivity
import org.quesong.quesookt.ui.viewmodel.OnboardViewModel

@AndroidEntryPoint
class ResultFragment : BindingFragment<FragmentResultBinding>(R.layout.fragment_result) {
    private val onboardViewModel: OnboardViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showResult()
        initClickEvent()
    }

    private fun showResult() {
        with(onboardViewModel.compareDormitory()) {
            binding.tvDormitory.text = this
            onboardViewModel.setDormitory(this)
        }
    }

    private fun initClickEvent() {
        binding.btnStart.setOnClickListener {
            startMainActivity()
        }
    }

    private fun startMainActivity() {
        startActivity(Intent(requireActivity(), MainActivity::class.java))
    }
}
