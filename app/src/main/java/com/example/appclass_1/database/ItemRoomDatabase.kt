package com.example.appclass_1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1, exportSchema = false)

abstract class ItemRoomDatabase:RoomDatabase() {

    //companion = static in java

    abstract fun itemDao(): ItemDao

    //companion = static in java

    companion object{
        //singleton design pattern
        private var INSTANCE: ItemRoomDatabase? = null

        fun getDatabase(context : Context):ItemRoomDatabase {
            //synchronized block
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,
                    ItemRoomDatabase::class.java,
                    "item_database")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }


    }

}