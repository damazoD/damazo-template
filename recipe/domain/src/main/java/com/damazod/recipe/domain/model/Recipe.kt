package com.damazod.recipe.domain.model

data class Recipe(
    val id: Long,
    val title: String,
    val image: String,
    val imageType: String
)