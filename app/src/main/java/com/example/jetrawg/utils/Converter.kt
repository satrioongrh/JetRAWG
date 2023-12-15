package com.example.jetrawg.utils
import androidx.room.TypeConverter
import com.example.jetrawg.data.network.model.DevelopersItem
import com.example.jetrawg.data.network.model.GenresItem
import com.example.jetrawg.data.network.model.PublishersItem
import com.example.jetrawg.data.network.model.RatingsItem
import com.example.jetrawg.data.network.model.Store
import com.example.jetrawg.data.network.model.TagsItem
import com.google.gson.Gson

class Converter {

    @TypeConverter
    fun fromRatingList(ratingList: List<RatingsItem?>): String {
        return Gson().toJson(ratingList)
    }

    @TypeConverter
    fun toRatingList(ratingList: String?): List<RatingsItem?> {
        return Gson().fromJson(ratingList, Array<RatingsItem?>::class.java).toList()
    }

    @TypeConverter
    fun fromGenresList(genreList: List<GenresItem?>): String {
        return Gson().toJson(genreList)
    }

    @TypeConverter
    fun toGenresList(genreList: String?): List<GenresItem?> {
        return Gson().fromJson(genreList, Array<GenresItem?>::class.java).toList()
    }

    @TypeConverter
    fun fromDeveloperList(developerList: List<DevelopersItem?>): String {
        return Gson().toJson(developerList)
    }

    @TypeConverter
    fun toDeveloperList(developerList: String?): List<DevelopersItem?> {
        return Gson().fromJson(developerList, Array<DevelopersItem?>::class.java).toList()
    }

    @TypeConverter
    fun fromTagList(tagList: List<TagsItem?>): String {
        return Gson().toJson(tagList)
    }

    @TypeConverter
    fun toTagList(tagList: String?): List<TagsItem?> {
        return Gson().fromJson(tagList, Array<TagsItem?>::class.java).toList()
    }


    @TypeConverter
    fun fromStoreList(storeList: List<Store?>): String {
        return Gson().toJson(storeList)
    }

    @TypeConverter
    fun toStoreList(storeList: String?): List<Store?> {
        return Gson().fromJson(storeList, Array<Store?>::class.java).toList()
    }

    @TypeConverter
    fun fromPublisherList(publisherList: List<PublishersItem?>): String {
        return Gson().toJson(publisherList)
    }

    @TypeConverter
    fun toPublisherList(publisherList: String?): List<PublishersItem?> {
        return Gson().fromJson(publisherList, Array<PublishersItem?>::class.java).toList()
    }

    @TypeConverter
    fun fromStringList(stringList: List<String?>): String {
        return Gson().toJson(stringList)
    }

    @TypeConverter
    fun toStringList(stringList: String?): List<String?> {
        return Gson().fromJson(stringList, Array<String?>::class.java).toList()
    }

}

