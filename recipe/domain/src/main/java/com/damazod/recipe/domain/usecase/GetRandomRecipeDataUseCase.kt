package com.damazod.recipe.domain.usecase

import com.damazod.recipe.domain.model.Recipe
import com.damazod.recipe.domain.repository.RandomRecipeRepository

class GetRandomRecipeDataUseCase(
    private val repository: RandomRecipeRepository
): GetRandomRecipeUseCase {

    override suspend fun getRandomRecipe(tags: List<String>): Recipe {
        return repository.getRandomRecipe(tags) ?: throw Exception("Not found!")
    }
}