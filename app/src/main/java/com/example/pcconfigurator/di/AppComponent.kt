package com.example.pcconfigurator.di

import android.content.Context
import com.example.data.di.DataModule
import com.example.data.di.RepositoryBindModule
import com.example.pcconfigurator.features.categoriesfeature.categories.CategoriesFragment
import com.example.pcconfigurator.features.favoritesfeature.favorites.FavoritesFragment
import com.example.pcconfigurator.features.pcbuildsfeature.builds.BuildsFragment
import com.example.pcconfigurator.features.pcbuildsfeature.makeabuild.MakeABuildFragment
import com.example.pcconfigurator.features.profile.ProfileFragment
import com.example.pcconfigurator.main.MainActivity
import com.example.pcconfigurator.main.MainContainerFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class, RepositoryBindModule::class, ViewModelModule::class, MainModule::class])
interface AppComponent {
    fun inject(buildsFragment: BuildsFragment)

    fun inject(categoriesFragment: CategoriesFragment)

    fun inject(favoritesFragment: FavoritesFragment)

    fun inject(profileFragment: ProfileFragment)

    fun inject(mainContainerFragment: MainContainerFragment)

    fun inject(makeABuildFragment: MakeABuildFragment)

    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun getContext(applicationContext: Context): Builder

        fun build(): AppComponent
    }
}
