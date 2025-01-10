package com.example.eco_alpha_test.di

import android.content.Context
import androidx.room.Room
import com.example.eco_alpha_test.data.AppDatabase
import com.example.eco_alpha_test.data.BINApi
import com.example.eco_alpha_test.data.BINRepositoryImpl
import com.example.eco_alpha_test.domain.BINRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object Module {
    @Provides
    @Singleton
    @Named("BaseUrl")
    fun providesBaseUrl(): String {
        return "https://lookup.binlist.net/"
    }

    @Provides
    @Singleton
    fun providesBINApi(retrofit: Retrofit): BINApi {
        return retrofit.create(BINApi::class.java)
    }

    @Provides
    @Singleton
    fun providesRetrofit(
        okHttpClient: OkHttpClient,
        @Named("BaseUrl") baseUrl: String
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesRepository(
        appDatabase: AppDatabase,
        binApi: BINApi
    ): BINRepository =
        BINRepositoryImpl(
            appDatabase,
            binApi
        )

    @Provides
    @Singleton
    fun providesOkHttpClient(interceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun providesLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun providesAppDatabase(@ApplicationContext context: Context): AppDatabase =
        Room
            .databaseBuilder(context, AppDatabase::class.java, "bindetail").build()
}

