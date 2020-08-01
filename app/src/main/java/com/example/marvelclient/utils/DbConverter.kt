package com.example.marvelclient.utils

import androidx.room.TypeConverter
import com.example.marvelclient.model.Thumbnail
import com.example.marvelclient.model.character.Character
import com.example.marvelclient.model.character.Url
import com.example.marvelclient.model.comic.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class DbConverter {

    private val gson = Gson()
    private val typeComic: Type = object: TypeToken<Comic>(){}.type
    private val typeThumbnail: Type = object: TypeToken<Thumbnail>() {}.type
    private val typeListThumbnail: Type = object: TypeToken<List<Thumbnail>>() {}.type
    private val typeListUrl: Type = object: TypeToken<List<Url>>(){}.type
    private val typeUrl: Type = object: TypeToken<Url>(){}.type
    private val typeDate: Type = object: TypeToken<Date>(){}.type
    private val typeListDate: Type = object: TypeToken<List<Date>>(){}.type
    private val typePrice: Type = object: TypeToken<Price>(){}.type
    private val typeListPrice: Type = object: TypeToken<List<Price>>(){}.type
    private val typeCharacter: Type = object: TypeToken<Character>(){}.type
    private val typeSeries: Type = object: TypeToken<Series>(){}.type
    private val typeCreator: Type = object: TypeToken<Creators>(){}.type

    @TypeConverter
    fun stringToComic(json: String?): Comic{
        return gson.fromJson(json,typeComic)
    }

    @TypeConverter
    fun comicToString(comic: Comic?): String{
        return gson.toJson(comic,typeComic)
    }

    @TypeConverter
    fun stringToListDate(json: String?): List<Date>{
        return gson.fromJson(json,typeListDate)
    }

    @TypeConverter
    fun listDateToString(dataList: List<Date>?): String{
        return gson.toJson(dataList,typeListDate)
    }

    @TypeConverter
    fun stringToCreators(json: String?): Creators{
        return gson.fromJson(json,typeCreator)
    }

    @TypeConverter
    fun creatorToString(creators: Creators?): String{
        return gson.toJson(creators,typeCreator)
    }


    @TypeConverter
    fun stringToThumbnail(json: String?): Thumbnail{
        return gson.fromJson(json,typeThumbnail)
    }

    @TypeConverter
    fun thumbnailToString(tb: Thumbnail?): String{
        return gson.toJson(tb,typeThumbnail)
    }

    @TypeConverter
    fun stringToListThumbnail(json: String?): List<Thumbnail>{
        return gson.fromJson(json,typeListThumbnail)
    }

    @TypeConverter
    fun listThumbnailToString(listImage: List<Thumbnail>?): String{
        return gson.toJson(listImage,typeListThumbnail)
    }

    @TypeConverter
    fun stringToListUrl(json: String?): List<Url>{
        return gson.fromJson(json,typeListUrl)
    }

    @TypeConverter
    fun listUrlToString(tb: List<Url>?): String{
        return gson.toJson(tb,typeListUrl)
    }

    @TypeConverter
    fun stringToUrl(json: String?): Url{
        return gson.fromJson(json,typeUrl)
    }

    @TypeConverter
    fun urlToString(tb: Url?): String{
        return gson.toJson(tb,typeUrl)
    }

    @TypeConverter
    fun stringToDate(json: String?): Date{
        return gson.fromJson(json,typeDate)
    }

    @TypeConverter
    fun dateToString(tb: Date?): String{
        return gson.toJson(tb,typeDate)
    }

    @TypeConverter
    fun stringToPrice(json: String?): Price{
        return gson.fromJson(json,typePrice)
    }

    @TypeConverter
    fun priceToString(tb: Price?): String{
        return gson.toJson(tb,typePrice)
    }

    @TypeConverter
    fun stringToCharacter(json: String?): Character{
        return gson.fromJson(json,typeCharacter)
    }

    @TypeConverter
    fun characterToString(tb: Character?): String{
        return gson.toJson(tb,typeCharacter)
    }

    @TypeConverter
    fun stringToSeries(json: String?): Series{
        return gson.fromJson(json,typeSeries)
    }

    @TypeConverter
    fun seriesToString(series: Series?): String{
        return gson.toJson(series,typeSeries)
    }

    @TypeConverter
    fun stringToListPrice(json: String?): List<Price>{
        return gson.fromJson(json,typeListPrice)
    }

    @TypeConverter
    fun listPriceToString(priceList: List<Price>?): String{
        return gson.toJson(priceList,typeListPrice)
    }
}