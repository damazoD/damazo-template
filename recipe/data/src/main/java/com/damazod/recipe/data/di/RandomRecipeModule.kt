package com.damazod.recipe.data.di

import com.damazod.recipe.data.repository.RandomRecipeDataRepository
import com.damazod.recipe.data.service.RandomRecipeService
import com.damazod.recipe.domain.repository.RandomRecipeRepository
import com.damazod.recipe.domain.usecase.GetRandomRecipeDataUseCase
import com.damazod.recipe.domain.usecase.GetRandomRecipeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object RandomRecipeModule {

    //TODO(Review this, is need to be in data or domain?)
    @Provides
    fun getRandomRecipeUseCase(randomRecipeRepository: RandomRecipeRepository): GetRandomRecipeUseCase {
        return GetRandomRecipeDataUseCase(randomRecipeRepository)
    }

    @Provides
    fun getRandomRecipeRepository(randomRecipeService: RandomRecipeService): RandomRecipeRepository {
        return RandomRecipeDataRepository(randomRecipeService)
    }

    @Provides
    fun getRandomRecipeService(retrofit: Retrofit): RandomRecipeService {
        return retrofit.create(RandomRecipeService::class.java)
    }
}