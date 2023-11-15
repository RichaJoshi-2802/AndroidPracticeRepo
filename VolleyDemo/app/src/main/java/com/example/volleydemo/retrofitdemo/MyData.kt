package com.example.volleydemo.retrofitdemo

data class MyData(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)