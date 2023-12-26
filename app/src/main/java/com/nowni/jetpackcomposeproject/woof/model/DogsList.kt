package com.nowni.jetpackcomposeproject.woof.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class DogsList(
    @DrawableRes val imageResId: Int,
    @StringRes val name: Int,
    val age: Int,
    @StringRes val hobbies:Int
)
