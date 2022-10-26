package com.damazod.recipe.data.model.response

@kotlinx.serialization.Serializable
data class RandomRecipeResponse(
    val recipes: List<Recipe>
)
