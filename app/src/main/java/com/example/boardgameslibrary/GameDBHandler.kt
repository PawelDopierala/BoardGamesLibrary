package com.example.boardgameslibrary

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class GameDBHandler(context: Context, name: String?,
                    factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context,
    DATABASE_NAME, factory, DATABASE_VERSION) {

    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "gameDB.db"
        val TABLE_GAMES = "games"
        val COLUMN_ID = "id"
        val COLUMN_TITLE = "title"
        val COLUMN_ORIGINAL_TITLE = "original_title"
        val COLUMN_PUBLISHMENT_YEAR = "publishment_year"
        val COLUMN_CURRENT_RANKING_POSITION = "current_ranking_position"
        val COLUMN_IMAGE = "image"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_PRODUCTS_TABLE = ("CREATE TABLE " + TABLE_GAMES +"(" + COLUMN_ID +
                " INTEGER PRIMARY KEY, " + COLUMN_TITLE + " TEXT, " + COLUMN_ORIGINAL_TITLE +
                " TEXT, " + COLUMN_PUBLISHMENT_YEAR + " INTEGER, " + COLUMN_CURRENT_RANKING_POSITION+
                " INTEGER, " + COLUMN_IMAGE + " TEXT" + ")")
        db.execSQL(CREATE_PRODUCTS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_GAMES)
        onCreate(db)
    }

    fun addGame(){
        val values = ContentValues()
        values.put(COLUMN_ID, 1)
        values.put(COLUMN_TITLE, "abc")
        val db = this.writableDatabase
        db.insert(TABLE_GAMES, null, values)
        db.close()
    }

//    fun addProduct(product: Product) {
//        val values = ContentValues()
//        values.put(COLUMN_PRODUCTNAME, product.productName)
//        values.put(COLUMN_QUANTITY, product.quantity)
//        val db = this.writableDatabase
//        db.insert(TABLE_PRODUCTS, null, values)
//        db.close()
//    }
//
//    fun findProduct(productName: String) : Product? {
//        val query = "SELECT * FROM $TABLE_PRODUCTS WHERE $COLUMN_PRODUCTNAME LIKE \"$productName\""
//        val db = this.writableDatabase
//        val cursor = db.rawQuery(query, null)
//        var product: Product? = null
//
//        if (cursor.moveToFirst()){
//            val id = cursor.getInt(0)
//            val name = cursor.getString(1)
//            val quantity = cursor.getInt(2)
//            product = Product(id, name, quantity)
//            cursor.close()
//        }
//        db.close()
//        return product
//    }
//
//    fun deleteProduct(productName: String): Boolean {
//        var result = false
//        val query = "SELECT * FROM $TABLE_PRODUCTS WHERE $COLUMN_PRODUCTNAME LIKE \"$productName\""
//
//        val db = this.writableDatabase
//        val cursor = db.rawQuery(query, null)
//        if(cursor.moveToFirst()) {
//            val id = cursor.getInt(0)
//            db.delete(TABLE_PRODUCTS, COLUMN_ID + " = ?", arrayOf(id.toString()))
//            cursor.close()
//            result = true
//        }
//        db.close()
//        return result
//    }
}