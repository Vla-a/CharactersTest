package com.example.characters.entities

import com.google.gson.annotations.SerializedName

class CharacterResponce(

    @SerializedName("info") val info: Info,
    @SerializedName("results") val results: List<Results>,
    @SerializedName("url") val url: String,
    @SerializedName("created") val created: String
)

class Info(
    @SerializedName("count") val count: Long,
    @SerializedName("pages") val pages: Long,
    @SerializedName("next") val next: String,
    @SerializedName("prev") val prev: String?
)

class Results(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String,
    @SerializedName("type") val type: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("origin") val origin: Origin,
    @SerializedName("location") val location: Location,
    @SerializedName("image") val image: String,
    @SerializedName("episod") val episod: List<String>,
    @SerializedName("url") val url: String,
    @SerializedName("created") val created: String
)

class Location(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

class Origin(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)