package com.example.android_practice_test.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ShoppingItem::class], version = 1)
abstract class ShoppingItemDB : RoomDatabase() {

    abstract fun shoppingDao() : ShoppingDao

    // companion object allows clients for creating or getting the database
    // without instantiating the class; there's no reason to instantiate it

//    companion object {
//        @Volatile
//        private var INSTANCE : ShoppingItemDB? = null
//
//        fun getInstance(context: Context) : ShoppingItemDB {
//            synchronized(this) {
//                var instance = INSTANCE
//                if(instance == null) {
//                    instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        ShoppingItemDB::class.java,
//                        "shopping_item_database"
//                    ).build()
//                    INSTANCE = instance
//                }
//                return instance
//            }
//        }
//    }

}