package com.example.pcconfigurator.favorites

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.pcconfigurator.databinding.FragmentFavoritesBinding
import com.example.pcconfigurator.utils.FavoritesAdapter

class FavoritesFragment : Fragment() {

    private val binding: FragmentFavoritesBinding by viewBinding(FragmentFavoritesBinding::bind)

    private val adapter: FavoritesAdapter by lazy {
        FavoritesAdapter()
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
    }
}