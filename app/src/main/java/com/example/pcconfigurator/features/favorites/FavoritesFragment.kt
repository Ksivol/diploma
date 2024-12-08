package com.example.pcconfigurator.features.favorites

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pcconfigurator.R
import com.example.pcconfigurator.databinding.FragmentFavoritesBinding
import com.example.pcconfigurator.di.inject
import com.example.pcconfigurator.utils.FavoritesAdapter
import javax.inject.Inject

class FavoritesFragment : Fragment(R.layout.fragment_favorites) {
    private val binding: FragmentFavoritesBinding by viewBinding(FragmentFavoritesBinding::bind)

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val adapter: FavoritesAdapter by lazy {
        FavoritesAdapter()
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
    }
}
