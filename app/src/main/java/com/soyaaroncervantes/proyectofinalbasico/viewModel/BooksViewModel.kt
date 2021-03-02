package com.soyaaroncervantes.proyectofinalbasico.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.soyaaroncervantes.proyectofinalbasico.model.Book
import com.soyaaroncervantes.proyectofinalbasico.network.Callback
import com.soyaaroncervantes.proyectofinalbasico.network.FirestoreService
import java.lang.Exception

class BooksViewModel: ViewModel() {
    val firestoreService = FirestoreService()
    val books = MutableLiveData< ArrayList<Book> >()
    val isLoading = MutableLiveData< Boolean >()

    fun refresh() {
        getBooks()
    }
    fun add( book: Book ) {
        addBook( book )
    }
    fun update( book: Book, position: Int ){
        updateBook( book, position )
    }
    fun delete( book: Book ){
        deleteBook( book )
    }

    private fun addBook( book: Book ) {
        firestoreService.addBook( book, object: Callback< Book > {
            override fun onSuccess( result: Book ) {
                val listBook = books.value
                listBook?.add( book )
                if (listBook != null) refreshBooksValue( listBook )
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }

        })
    }

    private fun getBooks() {
        firestoreService.getBooks( object: Callback< ArrayList<Book> > {
            override fun onSuccess( result: ArrayList<Book> ) {
                refreshBooksValue( result )
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })
    }

    private fun updateBook( book: Book, position: Int ) {
        firestoreService.updateBook( book, object: Callback< Book > {
            override fun onSuccess( result: Book ) {
                val listBook = books.value
                listBook?.set( position, result )
                if (listBook != null) refreshBooksValue( listBook )

            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }

        })

    }

    private fun deleteBook( book: Book ) {
        firestoreService.deleteBook( book.id.toString(), object: Callback< String > {
            override fun onSuccess(result: String) {
                val listBook = books.value
                listBook?.remove( book )
                if (listBook != null) refreshBooksValue( listBook )
            }

            override fun onFailed(exception: Exception) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun processFinished() {
        isLoading.value = true
    }

    private fun refreshBooksValue(value: ArrayList<Book> ) {
        books.postValue( value )
        processFinished()
    }
}