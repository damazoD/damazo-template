package com.damazod.recipe.data.model.response

@kotlinx.serialization.Serializable
data class Recipe(
    val id: Long?,
    val title: String?,
    val image: String?,
    val imageType: String?
)