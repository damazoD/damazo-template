package com.damazod.recipe.data.service

import com.damazod.recipe.data.model.response.RandomRecipeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomRecipeService {

    @GET("recipes/random")
    suspend fun getRandomRecipes(
        @Query("limitLicense") limitLicense: Boolean,
        @Query("tags") tags: String,
        @Query("number") number: Int,
    ): RandomRecipeResponse
}