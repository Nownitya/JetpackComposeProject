package com.nowni.jetpackcomposeproject.apps_list1.woof.data

import com.nowni.jetpackcomposeproject.R
import com.nowni.jetpackcomposeproject.apps_list1.woof.model.DogsList

object DataSourceDogs {
    val dogs = listOf(
        DogsList(R.drawable.koda, R.string.dog_name_1, 2, R.string.dog_description_1),
        DogsList(R.drawable.lola, R.string.dog_name_2, 16, R.string.dog_description_2),
        DogsList(R.drawable.frankie, R.string.dog_name_3, 2, R.string.dog_description_3),
        DogsList(R.drawable.nox, R.string.dog_name_4, 8, R.string.dog_description_4),
        DogsList(R.drawable.faye, R.string.dog_name_5, 8, R.string.dog_description_5),
        DogsList(R.drawable.bella, R.string.dog_name_6, 14, R.string.dog_description_6),
        DogsList(R.drawable.moana, R.string.dog_name_7, 2, R.string.dog_description_7),
        DogsList(R.drawable.tzeitel, R.string.dog_name_8, 7, R.string.dog_description_8),
        DogsList(R.drawable.leroy, R.string.dog_name_9, 4, R.string.dog_description_9)
    )
}