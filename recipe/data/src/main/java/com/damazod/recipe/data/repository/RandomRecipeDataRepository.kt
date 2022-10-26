package com.damazod.recipe.data.repository

import com.damazod.recipe.data.model.request.RandomRecipeRequest
import com.damazod.recipe.data.service.RandomRecipeService
import com.damazod.recipe.domain.model.Recipe
import com.damazod.recipe.domain.repository.RandomRecipeRepository
import javax.inject.Inject

class RandomRecipeDataRepository @Inject constructor(
    private val randomRecipeService: RandomRecipeService
) : RandomRecipeRepository {

    override suspend fun getRandomRecipe(tags: List<String>): Recipe? {
        val requestModel = RandomRecipeRequest(
            limitLicense = true,
            tags = tags.joinToString(separator = ","),
            number = 1
        )
        val response = randomRecipeService
            .getRandomRecipes(requestModel.limitLicense, requestModel.tags, requestModel.number)
            .recipes

        return response.map {
            Recipe(
                it.id ?: 0,
                it.title ?: "",
                it.image ?: "",
                it.imageType ?: ""
            )
        }.firstOrNull()
    }
}