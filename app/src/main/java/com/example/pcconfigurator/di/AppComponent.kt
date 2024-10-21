package com.example.pcconfigurator.di

import android.content.Context
import com.example.data.di.DataModule
import com.example.data.di.RepositoryBindModule
import com.example.pcconfigurator.categories.CategoriesFragment
import com.example.pcconfigurator.favorites.FavoritesFragment
import com.example.pcconfigurator.pcBuilds.BuildsFragment
import com.example.pcconfigurator.profile.ProfileFragment
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DataModule::class, RepositoryBindModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(buildsFragment: BuildsFragment)

    fun inject(categoriesFragment: CategoriesFragment)

    fun inject(favoritesFragment: FavoritesFragment)

    fun inject(profileFragment: ProfileFragment)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun getContext(applicationContext: Context): Builder

        fun build(): AppComponent
    }
}
