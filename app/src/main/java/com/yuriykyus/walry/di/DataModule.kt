package com.yuriykyus.walry.di

import android.content.Context
import com.yuriykyus.walry.data.network.Network
import com.yuriykyus.walry.data.network.NetworkManager
import com.yuriykyus.walry.data.repository.CityRepositoryImpl
import com.yuriykyus.walry.data.repository.PhotosRepositoryImpl
import com.yuriykyus.walry.data.storage.CityStorage
import com.yuriykyus.walry.data.storage.sharedprefs.CitySharedPrefs
import com.yuriykyus.walry.domain.repository.CityRepository
import com.yuriykyus.walry.domain.repository.PhotoRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideNetworkManager(): Network {
        return NetworkManager()
    }
    @Provides
    fun providePhotoRepository(networkManager: Network): PhotoRepository {
        return PhotosRepositoryImpl(network = networkManager)
    }
    @Provides
    fun provideCityStorage(context: Context): CityStorage {
        return CitySharedPrefs(context = context)
    }
    @Provides
    fun provideCityRepository(cityStorageImpl: CityStorage): CityRepository {
        return CityRepositoryImpl(cityStorageImpl = cityStorageImpl)
    }
}

