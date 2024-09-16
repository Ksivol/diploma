package com.example.pcconfigurator.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pcconfigurator.R
import com.example.pcconfigurator.databinding.FragmentMainContainerBinding

class MainContainerFragment : Fragment(R.layout.fragment_main_container) {
    private val binding: FragmentMainContainerBinding by viewBinding(FragmentMainContainerBinding::bind)

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
    }
}
