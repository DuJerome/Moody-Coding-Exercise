package com.dushanesmith.moodycodingexercise.di

import com.dushanesmith.moodycodingexercise.data.model.api.remote.PostApi
import com.dushanesmith.moodycodingexercise.data.repository.CardRepository
import com.dushanesmith.moodycodingexercise.data.repository.CardRepositoryImpl
import com.dushanesmith.moodycodingexercise.ui.theme.util.Constants.baseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/*
Here is a simple app module for dependency injection of PostApi into PostRepository
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePostApi(): PostApi{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostApi::class.java)
    }

    @Provides
    @Singleton
    fun providePostRepository(postApi: PostApi): CardRepository {
        return CardRepositoryImpl(postApi)
    }
}