package com.example.marvelclient.model.comic


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.marvelclient.model.Thumbnail
import com.example.marvelclient.model.character.Url
import com.example.marvelclient.utils.DbConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "comic_table")
@TypeConverters(DbConverter::class)
data class Comic(
    @SerializedName("characters")
    val characters: Creators,
    @SerializedName("dates")
    val dates: List<Date>,
    @SerializedName("diamondCode")
    val diamondCode: String,
    @SerializedName("digitalId")
    val digitalId: Int,
    @SerializedName("ean")
    val ean: String,
    @SerializedName("format")
    val format: String,
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("isbn")
    val isbn: String,
    @SerializedName("issn")
    val issn: String,
    @SerializedName("issueNumber")
    val issueNumber: Double,
    @SerializedName("modified")
    val modified: String,
    @SerializedName("pageCount")
    val pageCount: Int,
    @SerializedName("prices")
    val prices: List<Price>,
    @SerializedName("resourceURI")
    val resourceURI: String,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail,
    @SerializedName("title")
    val title: String,
    @SerializedName("upc")
    val upc: String,
    @SerializedName("variantDescription")
    val variantDescription: String,
    @SerializedName("urls")
    val urls: List<Url>,
    @SerializedName("images")
    val images: List<Thumbnail>
)