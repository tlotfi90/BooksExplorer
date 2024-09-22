package com.example.booksexplorer.domain.data

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("docs") val books: List<Book>
)
