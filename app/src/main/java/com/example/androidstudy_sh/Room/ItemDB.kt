package com.example.androidstudy_sh.Room

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ItemData::class], version = 1)
abstract class ItemDB : RoomDatabase() {
    abstract fun itemDao(): DAO
}