package com.example.androidstudy_sh.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DAO {

    @Insert
    fun insertPost(itemData: ItemData)

    @Query("SELECT * FROM ItemData")
    fun getAll() : MutableList<ItemData>


}