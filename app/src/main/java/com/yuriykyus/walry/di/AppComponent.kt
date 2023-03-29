package com.yuriykyus.walry.di

import com.yuriykyus.walry.presentation.fragments.SearchFragment
import com.yuriykyus.walry.presentation.fragments.WallpaperFragment
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {
    fun inject(searchFragment: SearchFragment)
    fun inject(wallpaperFragment: WallpaperFragment)
}