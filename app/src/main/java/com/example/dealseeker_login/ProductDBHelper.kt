package com.example.dealseeker_login

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.dealseeker_login.model.Product

class ProductDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    // Database and table information
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "ProductDatabase"
        private const val TABLE_PRODUCTS = "products"
        private const val KEY_ID = "id"
        private const val KEY_NAME = "name"
        private const val KEY_PRICE = "price"
        private const val KEY_STORE = "store"
        private const val KEY_WISHLIST = "wishlist"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = "CREATE TABLE $TABLE_PRODUCTS ($KEY_ID INTEGER PRIMARY KEY, $KEY_NAME TEXT, $KEY_PRICE REAL, $KEY_STORE TEXT,  $KEY_WISHLIST INTEGER )"
        db?.execSQL(createTableQuery)
    }
    // Add a method to update the wishlist status of a product
    fun updateWishlistStatus(productId: Int, isInWishlist: Boolean) {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(KEY_WISHLIST, if (isInWishlist) 1 else 0)
        }
        db.update(TABLE_PRODUCTS, values, "$KEY_ID=?", arrayOf(productId.toString()))
        db.close()
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_PRODUCTS")
        onCreate(db)
    }


    fun addProduct(product: Product) {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(KEY_NAME, product.name)
            put(KEY_PRICE, product.price)
            put(KEY_STORE, product.store)
        }
        db.insert(TABLE_PRODUCTS, null, values)
        db.close()
    }

    @SuppressLint("Range")
    fun searchProductsByName(name: String): List<Product> {
        val productList = mutableListOf<Product>()
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_PRODUCTS WHERE $KEY_NAME LIKE ?"
        val cursor = db.rawQuery(query, arrayOf("%$name%"))

        cursor?.use {
            while (it.moveToNext()) {
                val id = it.getInt(it.getColumnIndex(KEY_ID))
                val productName = it.getString(it.getColumnIndex(KEY_NAME))
                val price = it.getDouble(it.getColumnIndex(KEY_PRICE))
                val store = it.getString(it.getColumnIndex(KEY_STORE))
                productList.add(Product(id, productName, price, store))
            }
        }

        cursor?.close()
        return productList
    }



}