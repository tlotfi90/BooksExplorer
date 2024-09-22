package com.example.booksexplorer.domain.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class Book(
    @SerializedName("key")
    val id: String,
    val title: String,
    @SerializedName("author_name")
    val authorName: List<String>?,
    @SerializedName("first_publish_year")
    val firstPublishYear: String?,
    @SerializedName("cover_i")
    val coverId: String?
):Parcelable