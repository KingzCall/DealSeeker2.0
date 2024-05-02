package com.example.dealseeker_login.model

import android.content.Context

object AppInitializer {

    //populating database with products from different stores for product search and price comparison instead
    //of using the internet
    fun initDatabase(context: Context) {
        val dbHelper = ProductDatabaseHelper(context)

        // Adding smartphone prices from three different stores
        val smartphone1 = Product(1, "Samsung Galaxy S21", 999.00, "Store A")
        val smartphone2 = Product(2, "Samsung Galaxy S21", 989.00, "Store B")
        val smartphone3 = Product(3, "Samsung Galaxy S21", 995.00, "Store C")

        // Adding laptop prices from three different stores
        val laptop1 = Product(4, "MacBook Pro", 1999.00, "Store A")
        val laptop2 = Product(5, "MacBook Pro", 1949.00, "Store B")
        val laptop3 = Product(6, "MacBook Pro", 2005.00, "Store C")

        // Adding tablet prices from three different stores
        val tablet1 = Product(7, "iPad Pro", 799.00, "Store A")
        val tablet2 = Product(8, "iPad Pro", 789.00, "Store B")
        val tablet3 = Product(9, "iPad Pro", 805.00, "Store C")

        // Inserting products into the database
        dbHelper.addProduct(smartphone1)
        dbHelper.addProduct(smartphone2)
        dbHelper.addProduct(smartphone3)
        dbHelper.addProduct(laptop1)
        dbHelper.addProduct(laptop2)
        dbHelper.addProduct(laptop3)
        dbHelper.addProduct(tablet1)
        dbHelper.addProduct(tablet2)
        dbHelper.addProduct(tablet3)
    }
}
