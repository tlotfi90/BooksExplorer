package com.example.booksexplorer.presentaion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.booksexplorer.R
import com.example.booksexplorer.presentaion.adapter.BookAdapter

class SearchFragment : Fragment() {

    private val viewModel: SearchViewModel by viewModels()
    private lateinit var adapter: BookAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchView = view.findViewById<SearchView>(R.id.searchView)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rc_bookResult)

        adapter = BookAdapter { book ->
            val action = SearchFragmentDirections.actionSearchFragment2ToDetailFragment(book)
            findNavController().navigate(action)
        }

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (!query.isNullOrEmpty()) {
                    viewModel.searchBooks(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean = true
        })

        viewModel.books.observe(viewLifecycleOwner) { books ->
           if(books.isEmpty())
               Toast.makeText(requireContext(),"No results found",Toast.LENGTH_SHORT).show()
            adapter.submitList(books)
        }
    }
}
