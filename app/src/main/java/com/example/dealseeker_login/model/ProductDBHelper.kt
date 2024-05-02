package com.example.dealseeker_login.model

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

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
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = "CREATE TABLE $TABLE_PRODUCTS ($KEY_ID INTEGER PRIMARY KEY, $KEY_NAME TEXT, $KEY_PRICE REAL, $KEY_STORE TEXT)"
        db?.execSQL(createTableQuery)
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

    // Other CRUD operations (read, update, delete) can be added here
}