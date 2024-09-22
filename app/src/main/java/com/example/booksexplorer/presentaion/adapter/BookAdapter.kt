package com.example.booksexplorer.presentaion.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load

import com.example.booksexplorer.domain.data.Book
import com.example.booksexplorer.databinding.BookItemBinding

class BookAdapter(private val onBookClick: (Book) -> Unit) :
    ListAdapter<Book, BookAdapter.BookViewHolder>(BookDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = BookItemBinding.inflate(inflater, parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class BookViewHolder(private val binding: BookItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(book: Book) {
            book.let {
                binding.resTitle.text = book.title
                binding.resAuthor.text = book.authorName?.joinToString(", ") ?: "Unknown Author"
                binding.image.load("https://covers.openlibrary.org/b/id/${book.coverId}-L.jpg") {

                }}

            binding.root.setOnClickListener {
                onBookClick(book)
            }
        }
    }
}

class BookDiffCallback : DiffUtil.ItemCallback<Book>() {
    override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean = oldItem == newItem
}
