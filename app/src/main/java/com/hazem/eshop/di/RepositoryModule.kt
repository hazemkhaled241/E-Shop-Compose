package com.hazem.eshop.di

import android.net.ConnectivityManager
import com.hazem.eshop.data.network.ApiService
import com.hazem.eshop.data.repository.HomeRepositoryImp
import com.hazem.eshop.domain.repository.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideHomeRepository(
        connectivityManager: ConnectivityManager, apiService: ApiService
    ): HomeRepository {
        return HomeRepositoryImp(
            apiService,
            connectivityManager
        )
    }
}