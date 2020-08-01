package com.example.marvelclient.model.comic


import com.google.gson.annotations.SerializedName

data class ComicResponse(
    @SerializedName("attributionHTML")
    val attributionHTML: String,
    @SerializedName("attributionText")
    val attributionText: String,
    @SerializedName("code")
    val code: Int,
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("etag")
    val etag: String,
    @SerializedName("status")
    val status: String
)