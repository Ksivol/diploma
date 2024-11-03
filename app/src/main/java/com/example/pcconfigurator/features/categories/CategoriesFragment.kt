package com.example.pcconfigurator.features.categories

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pcconfigurator.R
import com.example.pcconfigurator.databinding.FragmentCategoriesBinding
import com.example.pcconfigurator.di.inject
import com.example.pcconfigurator.main.MainViewModel
import com.example.pcconfigurator.utils.CategoriesAdapter
import javax.inject.Inject

class CategoriesFragment : Fragment(R.layout.fragment_categories) {
    private val binding: FragmentCategoriesBinding by viewBinding(FragmentCategoriesBinding::bind)

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val mainViewModel: MainViewModel by activityViewModels {
        factory
    }

    private val adapter: CategoriesAdapter by lazy {
        CategoriesAdapter()
    }

    override fun onAttach(context: Context) {
        inject()
        super.onAttach(context)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        setTilte()
    }

    private fun setTilte() {
        mainViewModel.setTitle(requireContext().getString(R.string.categories))
    }
}
