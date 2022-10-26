package com.damazod.recipe.domain.usecase

import com.damazod.recipe.domain.model.Recipe

interface GetRandomRecipeUseCase {
    suspend fun getRandomRecipe(tags: List<String>): Recipe
}