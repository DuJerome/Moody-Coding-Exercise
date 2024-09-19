package com.dushanesmith.moodycodingexercise.di

import com.dushanesmith.moodycodingexercise.data.model.api.remote.PostApi
import com.dushanesmith.moodycodingexercise.data.repository.PostRepository
import com.dushanesmith.moodycodingexercise.data.repository.PostRepositoryImpl
import com.dushanesmith.moodycodingexercise.ui.theme.util.Constants.baseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

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
    fun providePostRepository(postApi: PostApi): PostRepository {
        return PostRepositoryImpl(postApi)
    }
}