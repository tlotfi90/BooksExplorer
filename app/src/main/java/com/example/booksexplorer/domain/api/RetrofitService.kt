package com.example.booksexplorer.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {


        private const val BASE_URL = "https://openlibrary.org/"

        val api: BookApi by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BookApi::class.java)
        }

}