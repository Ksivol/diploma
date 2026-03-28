package com.example.pcconfigurator.features.categories

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.data.database.MainDataBase
import com.example.domain.usecases.GetCoolersUseCase
import com.example.pcconfigurator.R
import com.example.pcconfigurator.databinding.FragmentCoolerListBinding
import com.example.pcconfigurator.di.appComponent
import com.example.pcconfigurator.utils.CoolerAdapter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class CoolerListFragment : Fragment(R.layout.fragment_cooler_list) {
    private val binding: FragmentCoolerListBinding by viewBinding(FragmentCoolerListBinding::bind)
    private val adapter: CoolerAdapter by lazy { CoolerAdapter() }

    @Inject
    lateinit var getCoolersUseCase: GetCoolersUseCase

    override fun onAttach(context: Context) {
        super.onAttach(context)

        appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.coolerRecyclerView.apply {
            adapter = this@CoolerListFragment.adapter
            layoutManager = LinearLayoutManager(requireContext())
        }

            getCoolersUseCase().onEach { coolers ->
                adapter.submitList(coolers)
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }
}
