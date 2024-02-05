package com.nowni.jetpackcomposeproject.apps_list.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val nameResourceId: Int,
    val availableCourse: Int,
    @DrawableRes val imageResourceId: Int,
)