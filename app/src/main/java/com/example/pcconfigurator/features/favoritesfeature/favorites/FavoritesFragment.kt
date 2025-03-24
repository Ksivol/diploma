package com.example.pcconfigurator.features.favoritesfeature.favorites

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pcconfigurator.R
import com.example.pcconfigurator.databinding.FragmentFavoritesBinding
import com.example.pcconfigurator.di.component
import com.example.pcconfigurator.main.MainViewModel
import com.example.pcconfigurator.utils.FavoritesAdapter
import com.github.terrakok.cicerone.androidx.FragmentScreen
import javax.inject.Inject

class FavoritesFragment : Fragment(R.layout.fragment_favorites) {
    private val binding: FragmentFavoritesBinding by viewBinding(FragmentFavoritesBinding::bind)

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val mainViewModel: MainViewModel by activityViewModels {
        factory
    }

    private val adapter: FavoritesAdapter by lazy {
        FavoritesAdapter()
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
        mainViewModel.setTitle(requireContext().getString(R.string.favorites))
    }

    companion object {
        fun Screen(): FragmentScreen = FragmentScreen { FavoritesFragment() }
    }
}
