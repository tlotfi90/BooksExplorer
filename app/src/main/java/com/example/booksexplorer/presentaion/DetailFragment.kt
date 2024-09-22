package com.example.booksexplorer.presentaion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.booksexplorer.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

 val args:DetailFragmentArgs by navArgs()
    lateinit var binding:FragmentDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.resTitle.text=args.book?.title
        binding.resAuthor.text= args.book!!.authorName?.get(0) ?: ""
        binding.resPublishYear.text=args.book?.firstPublishYear
        binding.image.load("https://covers.openlibrary.org/b/id/${args.book?.coverId}-L.jpg")


    }


}