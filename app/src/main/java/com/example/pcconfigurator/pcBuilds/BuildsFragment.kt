package com.example.pcconfigurator.pcBuilds

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pcconfigurator.R
import com.example.pcconfigurator.databinding.FragmentBuildsBinding
import com.example.pcconfigurator.utils.BuildsAdapter

class BuildsFragment : Fragment(R.layout.fragment_builds) {
    private val binding: FragmentBuildsBinding by viewBinding(FragmentBuildsBinding::bind)

    private val adapter: BuildsAdapter by lazy {
        BuildsAdapter()
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
    }
}
