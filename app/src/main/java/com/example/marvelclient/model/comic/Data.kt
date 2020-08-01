package com.example.marvelclient.model.comic


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("count")
    val count: Int,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("results")
    val comics: List<Comic>,
    @SerializedName("total")
    val total: Int
)