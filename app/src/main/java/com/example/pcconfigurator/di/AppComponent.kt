package com.example.pcconfigurator.di

import android.content.Context
import com.example.data.di.DataModule
import com.example.data.di.RepositoryBindModule
import com.example.pcconfigurator.features.categoriesfeature.categories.CategoriesFragment
import com.example.pcconfigurator.features.favoritesfeature.favorites.FavoritesFragment
import com.example.pcconfigurator.features.pcbuildsfeature.builds.BuildsFragment
import com.example.pcconfigurator.features.pcbuildsfeature.makeabuild.MakeABuildFragment
import com.example.pcconfigurator.features.profilefeature.profile.ProfileFragment
import com.example.pcconfigurator.main.MainContainerFragment
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DataModule::class, RepositoryBindModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(buildsFragment: BuildsFragment)

    fun inject(categoriesFragment: CategoriesFragment)

    fun inject(favoritesFragment: FavoritesFragment)

    fun inject(profileFragment: ProfileFragment)

    fun inject(mainContainerFragment: MainContainerFragment)

    fun inject(makeABuildFragment: MakeABuildFragment)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun getContext(applicationContext: Context): Builder

        fun build(): AppComponent
    }
}
