package com.damazod.recipe.data.model.request

@kotlinx.serialization.Serializable
data class RandomRecipeRequest(
    val limitLicense: Boolean,
    val tags: String,
    val number: Int
)