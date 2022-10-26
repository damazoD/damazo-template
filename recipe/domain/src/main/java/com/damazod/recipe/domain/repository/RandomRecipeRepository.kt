package com.damazod.recipe.domain.repository

import com.damazod.recipe.domain.model.Recipe

interface RandomRecipeRepository {
    suspend fun getRandomRecipe(tags: List<String>): Recipe?
}