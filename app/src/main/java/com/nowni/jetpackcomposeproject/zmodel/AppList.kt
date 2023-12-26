package com.nowni.jetpackcomposeproject.zmodel

import androidx.annotation.StringRes

data class AppList(
    @StringRes val nameId:Int
)

data class AppLists(
    val listId:Int,
    @StringRes val nameId:Int
)