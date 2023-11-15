package com.example.adaptordemo.three

import com.example.adaptordemo.R

data class Images(
    var animalName: String,
    var animalImage: Int
)

object MyImages{
    val images = arrayOf(
        Images("Hand", R.drawable.hand),
        Images("Album", R.drawable.album),
        Images("Analytics", R.drawable.analytics),
        Images("Home", R.drawable.home),
        Images("Moon", R.drawable.moon)
    )
}