package com.example.androidstudy_sh.Room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ItemData (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo var imgUrl : String?,
    @ColumnInfo var title : String?,
    @ColumnInfo var subscript : String?
)