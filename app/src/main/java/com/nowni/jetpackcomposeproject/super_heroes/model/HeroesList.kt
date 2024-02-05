package com.nowni.jetpackcomposeproject.super_heroes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class HeroesList(
    @StringRes val superHeroesName: Int,
    @StringRes val superHeroesDescription : Int,
    @DrawableRes val superHeroesImage: Int
)
