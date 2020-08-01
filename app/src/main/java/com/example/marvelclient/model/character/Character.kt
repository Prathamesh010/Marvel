package com.example.marvelclient.model.character


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.marvelclient.model.Thumbnail
import com.example.marvelclient.model.comic.Comic
import com.example.marvelclient.model.comic.Series
import com.example.marvelclient.utils.DbConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "character_table")
@TypeConverters(DbConverter::class)
data class Character(
    @SerializedName("comics")
    val comics: Comic,
    @SerializedName("description")
    val description: String,
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("modified")
    val modified: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("resourceURI")
    val resourceURI: String,
    @SerializedName("series")
    val series: Series,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail,
    @SerializedName("urls")
    val urls: List<Url>
)