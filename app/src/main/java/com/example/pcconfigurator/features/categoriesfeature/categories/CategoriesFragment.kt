package com.example.pcconfigurator.features.categoriesfeature.categories

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pcconfigurator.R
import com.example.pcconfigurator.databinding.FragmentCategoriesBinding
import com.example.pcconfigurator.di.component
import com.example.pcconfigurator.features.categoriesfeature.utils.CategoriesAdapter
import com.example.pcconfigurator.main.MainViewModel
import javax.inject.Inject
import com.example.pcconfigurator.di.appComponent
import com.example.pcconfigurator.models.Category
import com.example.pcconfigurator.utils.CategoriesAdapter

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
        mainViewModel.setTitle(requireContext().getString(R.string.categories))
        setupRecyclerView()
        loadCategories()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            adapter = this@CategoriesFragment.adapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }

    private fun loadCategories() {
        val categories = listOf(
            Category(1, R.drawable.cl_ic, "Охлаждение"),
            Category(2, R.drawable.cs_ic, "Корпуса"),
            Category(3, R.drawable.hd_ic, "Накопители"),
            Category(4, R.drawable.ps_ic, "Блоки питания"),
            Category(5, R.drawable.vc_ic, "Видеокарты"),
            Category(6, R.drawable.mb_ic, "Материнские платы"),
            Category(7, R.drawable.ram_ic, "Оперативная память"),
            Category(8, R.drawable.cpu_ic, "Процессоры")
        )
        adapter.submitList(categories)
    }
}
