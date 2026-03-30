package com.example.pcconfigurator.features.categoriesfeature.categories

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pcconfigurator.R
import com.example.pcconfigurator.databinding.FragmentCoolerListBinding
import com.example.pcconfigurator.di.component
import com.example.pcconfigurator.utils.CoolerAdapter
import com.github.terrakok.cicerone.androidx.FragmentScreen
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class CoolerListFragment : Fragment(R.layout.fragment_cooler_list) {
    private val binding: FragmentCoolerListBinding by viewBinding(FragmentCoolerListBinding::bind)
    private val adapter: CoolerAdapter by lazy { CoolerAdapter{} }

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    
    private val viewModel: CoolerViewModel by viewModels { factory }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        binding.coolerRecyclerView.apply {
            adapter = this@CoolerListFragment.adapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun observeViewModel() {
        viewModel.coolers
            .onEach { coolers ->
                adapter.submitList(coolers)
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    class Screen : FragmentScreen {
        override fun createFragment(factory: androidx.fragment.app.FragmentFactory): Fragment = CoolerListFragment()
    }
}
