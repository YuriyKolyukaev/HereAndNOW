package com.yuriykyus.walry.di

import com.yuriykyus.walry.domain.repository.CityRepository
import com.yuriykyus.walry.domain.repository.PhotoRepository
import com.yuriykyus.walry.domain.usecase.GetCityNameUseCase
import com.yuriykyus.walry.domain.usecase.GetPhotosUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun provideGetCityNameUseCase(cityRepository: CityRepository): GetCityNameUseCase {
        return GetCityNameUseCase(cityRepository = cityRepository)
    }
    @Provides
    fun provideGetPhotoUseCase(photoRepository: PhotoRepository): GetPhotosUseCase {
        return GetPhotosUseCase(photoRepository = photoRepository)
    }
}