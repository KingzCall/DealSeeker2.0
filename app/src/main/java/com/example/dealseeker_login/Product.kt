package com.example.dealseeker_login

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val store: String,
    var isInWishlist: Boolean = false
)
