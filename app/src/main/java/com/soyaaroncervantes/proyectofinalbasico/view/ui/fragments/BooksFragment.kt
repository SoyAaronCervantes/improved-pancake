package com.soyaaroncervantes.proyectofinalbasico.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.soyaaroncervantes.proyectofinalbasico.R
import com.soyaaroncervantes.proyectofinalbasico.model.Book
import com.soyaaroncervantes.proyectofinalbasico.view.adapter.BooksAdapter
import com.soyaaroncervantes.proyectofinalbasico.view.adapter.BooksListener
import com.soyaaroncervantes.proyectofinalbasico.viewModel.BooksViewModel

class BooksFragment : Fragment(), BooksListener {
    private lateinit var booksAdapter: BooksAdapter
    private lateinit var booksViewModel: BooksViewModel

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        return inflater.inflate(R.layout.fragment_books, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        booksViewModel = ViewModelProvider( this ).get( BooksViewModel::class.java )
        booksViewModel.refresh()

        booksAdapter = BooksAdapter( this )

        view.findViewById<RecyclerView>(R.id.recyclerViewBooks).apply {
            layoutManager = LinearLayoutManager( view.context, LinearLayoutManager.VERTICAL, false )
            adapter = booksAdapter
        }
        observerViewModel( view )

    }

    private fun observerViewModel( view: View ) {
        booksViewModel.books.observe( viewLifecycleOwner, {
            it.let { booksAdapter.updateData( it ) }
        })

        booksViewModel.isLoading.observe( this.viewLifecycleOwner, {
            if ( it != null ) {
                view.findViewById<RelativeLayout>( R.id.relativeLayoutBaseSchedule )
                    .visibility =View.INVISIBLE
            }
        })
    }

    override fun onBookClick(book: Book, position: Int) {
        TODO("Not yet implemented")
    }
}