package com.example.marvelclient.avengers

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.marvelclient.model.Thumbnail
import com.example.marvelclient.utils.DbConverter

@Entity(tableName = "avenger_table")
@TypeConverters(DbConverter::class)
data class Avenger(
    @PrimaryKey
    val id: Int,
    val name: String,
    val thumbnail: Thumbnail
)