package com.example.booksexplorer.api

import com.example.booksexplorer.domain.data.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface BookApi {
    @GET("search.json")
    suspend fun searchBooks(@Query("title") title: String): SearchResponse
}