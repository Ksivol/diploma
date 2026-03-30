package com.example.pcconfigurator.features.profile

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pcconfigurator.R
import com.example.pcconfigurator.databinding.FragmentProfileBinding
import com.example.pcconfigurator.di.component
import com.example.pcconfigurator.main.MainViewModel
import com.github.terrakok.cicerone.androidx.FragmentScreen
import javax.inject.Inject

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private val binding: FragmentProfileBinding by viewBinding(FragmentProfileBinding::bind)

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        setTitle()
    }

    private fun setTitle() {
        mainViewModel.setTitle(requireContext().getString(R.string.profile))
    }

    class Screen : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment = ProfileFragment()
    }
}
