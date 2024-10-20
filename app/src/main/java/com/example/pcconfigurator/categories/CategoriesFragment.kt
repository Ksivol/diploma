package com.example.pcconfigurator.categories

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pcconfigurator.R
import com.example.pcconfigurator.databinding.FragmentCategoriesBinding
import com.example.pcconfigurator.utils.CategoriesAdapter

class CategoriesFragment : Fragment(R.layout.fragment_categories) {

    private val binding: FragmentCategoriesBinding by viewBinding(FragmentCategoriesBinding::bind)

    private val adapter: CategoriesAdapter by lazy {
        CategoriesAdapter()
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
    }
}