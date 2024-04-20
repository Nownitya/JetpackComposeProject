package com.nowni.JetpackComposeProject.apps_list1.affirmations_initial_app.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int

)
