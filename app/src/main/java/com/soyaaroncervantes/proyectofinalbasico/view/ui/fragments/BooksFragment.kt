package com.soyaaroncervantes.proyectofinalbasico.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.soyaaroncervantes.proyectofinalbasico.R
import com.soyaaroncervantes.proyectofinalbasico.model.Book
import com.soyaaroncervantes.proyectofinalbasico.view.adapter.BookAdapter
import com.soyaaroncervantes.proyectofinalbasico.view.adapter.BookListener
import com.soyaaroncervantes.proyectofinalbasico.viewModel.BooksViewModel

class BooksFragment : Fragment(), BookListener {
    private lateinit var bookAdapter: BookAdapter
    private lateinit var booksViewModel: BooksViewModel

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        return inflater.inflate(R.layout.fragment_books, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        booksViewModel = ViewModelProvider( this ).get( BooksViewModel::class.java )
        booksViewModel.refresh()

        bookAdapter = BookAdapter( this )

    }

    override fun onBookClick(book: Book, position: Int) {
        TODO("Not yet implemented")
    }
}