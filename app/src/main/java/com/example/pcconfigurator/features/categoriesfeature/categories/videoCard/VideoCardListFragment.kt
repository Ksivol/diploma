package com.example.pcconfigurator.features.categoriesfeature.categories.videoCard

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pcconfigurator.R
import com.example.pcconfigurator.databinding.FragmentCoolerListBinding
import com.example.pcconfigurator.di.component
import com.example.pcconfigurator.utils.VideoCardAdapter
import com.github.terrakok.cicerone.androidx.FragmentScreen
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class VideoCardListFragment : Fragment(R.layout.fragment_cooler_list) {
    private val binding: FragmentCoolerListBinding by viewBinding(FragmentCoolerListBinding::bind)
    private val adapter: VideoCardAdapter by lazy { VideoCardAdapter{item -> viewModel.onFavoriteClick(item)} }

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    
    private val viewModel: VideoCardListViewModel by viewModels { factory }

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
            adapter = this@VideoCardListFragment.adapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun observeViewModel() {
        viewModel.videoCards
            .onEach { videoCards ->
                adapter.submitList(videoCards)
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    class Screen : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment = VideoCardListFragment()
    }
}
