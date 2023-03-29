package com.yuriykyus.walry.di

import android.content.Context
import com.yuriykyus.walry.domain.usecase.GetCityNameUseCase
import com.yuriykyus.walry.domain.usecase.GetPhotosUseCase
import com.yuriykyus.walry.presentation.PhotoViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideViewModelFactory(
        getCityNameUseCase: GetCityNameUseCase,
        getPhotosUseCase: GetPhotosUseCase
    ): PhotoViewModelFactory {
        return PhotoViewModelFactory(getCityNameUseCase, getPhotosUseCase)
    }
}