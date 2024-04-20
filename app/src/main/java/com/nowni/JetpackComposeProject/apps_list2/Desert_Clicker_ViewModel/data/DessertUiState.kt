package com.nowni.JetpackComposeProject.apps_list2.Desert_Clicker_ViewModel.data

import androidx.annotation.DrawableRes

data class DessertUiState(
    val currentDessertIndex: Int = 0,
    val dessertsSold: Int = 0,
    val revenue: Int = 0,
    val currentDessertPrice: Int = 0,
    @DrawableRes val currentDessertImageId: Int = 0
)