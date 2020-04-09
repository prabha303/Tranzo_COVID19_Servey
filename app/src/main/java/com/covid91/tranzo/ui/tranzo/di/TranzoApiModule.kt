package com.covid91.tranzo.ui.tranzo.di
import com.covid91.tranzo.ui.repository.FuelStationApiService
import com.covid91.tranzo.ui.repository.FuelStationRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class TranzoApiModule {
    @TranzoServeyScope
    @Provides
    fun provideAbortApiService(retrofit: Retrofit): FuelStationApiService {
        return retrofit.create(FuelStationApiService::class.java)
    }

    @TranzoServeyScope
    @Provides
    fun provideDashboardRepository(apiService: FuelStationApiService): FuelStationRepository {
        return FuelStationRepository(apiService)
    }


}