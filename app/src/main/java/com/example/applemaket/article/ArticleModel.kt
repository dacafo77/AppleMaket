package com.example.applemaket.article

data class ArticleModel (
    val name: String,
    val seller : String,
    val address: String,
    val pric: Int = 0,
    val imageUrl: Int,
    val text : String

)