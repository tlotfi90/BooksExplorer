package com.example.booksexplorer.presentaion

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booksexplorer.api.RetrofitService
import com.example.booksexplorer.domain.data.Book
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> = _books

    fun searchBooks(query: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitService.api.searchBooks(query)
                Log.e("HIII", "searchBooks: $response" )
                _books.value = response.books
            } catch (e: Exception) {
                _books.value = emptyList()
            }
        }
    }
}