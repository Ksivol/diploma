package com.example.pcconfigurator.features.categoriesfeature.categories

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pcconfigurator.R
import com.example.pcconfigurator.databinding.FragmentCategoriesBinding
import com.example.pcconfigurator.di.component
import com.example.pcconfigurator.features.categoriesfeature.categories.cooler.CoolerListFragment
import com.example.pcconfigurator.features.categoriesfeature.categories.cpu.CpuListFragment
import com.example.pcconfigurator.features.categoriesfeature.categories.hardDrive.HardDriveListFragment
import com.example.pcconfigurator.features.categoriesfeature.categories.mothervoard.MotherboardListFragment
import com.example.pcconfigurator.features.categoriesfeature.categories.psCase.PcCaseListFragment
import com.example.pcconfigurator.features.categoriesfeature.categories.psu.PsuListFragment
import com.example.pcconfigurator.features.categoriesfeature.categories.ram.RamListFragment
import com.example.pcconfigurator.features.categoriesfeature.categories.videoCard.VideoCardListFragment
import com.example.pcconfigurator.features.categoriesfeature.models.Category
import com.example.pcconfigurator.features.categoriesfeature.utils.CategoriesAdapter
import com.example.pcconfigurator.main.MainContainerViewModel
import com.example.pcconfigurator.main.MainViewModel
import com.github.terrakok.cicerone.androidx.FragmentScreen
import javax.inject.Inject

class CategoriesFragment : Fragment(R.layout.fragment_categories) {
    private val binding: FragmentCategoriesBinding by viewBinding(FragmentCategoriesBinding::bind)

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val mainViewModel: MainViewModel by activityViewModels {
        factory
    }

    private val containerViewModel: MainContainerViewModel by activityViewModels {
        factory
    }

    private val adapter: CategoriesAdapter by lazy {
        CategoriesAdapter { category ->
            val screen = when (category.id) {
                1 -> {
                    mainViewModel.setTitle(requireContext().getString(R.string.cooler))
                    CoolerListFragment.Screen()
                }

                2 -> {
                    mainViewModel.setTitle(requireContext().getString(R.string.ps_case))
                    PcCaseListFragment.Screen()
                }

                3 -> {
                    mainViewModel.setTitle(requireContext().getString(R.string.hard_drive))
                    HardDriveListFragment.Screen()
                }

                4 -> {
                    mainViewModel.setTitle(requireContext().getString(R.string.psu))
                    PsuListFragment.Screen()
                }

                5 -> {
                    mainViewModel.setTitle(requireContext().getString(R.string.video_card))
                    VideoCardListFragment.Screen()
                }

                6 -> {
                    mainViewModel.setTitle(requireContext().getString(R.string.motherboard))
                    MotherboardListFragment.Screen()
                }

                7 -> {
                    mainViewModel.setTitle(requireContext().getString(R.string.ram))
                    RamListFragment.Screen()
                }

                8 -> {
                    mainViewModel.setTitle(requireContext().getString(R.string.cpu))
                    CpuListFragment.Screen()
                }

                else -> null
            }
            screen?.let { containerViewModel.navigateTo(it) }
        }
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
        setupRecyclerView()
        loadCategories()
    }

    private fun setTitle() {
        mainViewModel.setTitle(requireContext().getString(R.string.categories))
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

    class Screen : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment = CategoriesFragment()
    }
}
