package com.damazod.recipe.presentation.random

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.damazod.recipe.domain.usecase.GetRandomRecipeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomRecipeViewModel @Inject constructor(
    private val getRandomRecipeUseCase: GetRandomRecipeUseCase
): ViewModel() {

    fun getRecipeRandom(){
        viewModelScope.launch {
            val randomRecipe = getRandomRecipeUseCase.getRandomRecipe(
                listOf("vegetarian", "dessert")
            )

            Log.d("test", "Model: $randomRecipe")
        }
    }
}