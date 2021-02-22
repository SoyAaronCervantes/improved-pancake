package com.soyaaroncervantes.proyectofinalbasico.network

import com.soyaaroncervantes.proyectofinalbasico.model.Book

interface BookCRUD {
    fun addBook( book: Book, callback: Callback< Book > )
    fun getBooks( callback: Callback< ArrayList<Book> > )
    fun getBook( id: String, callback: Callback< Book > )
    fun updateBook( book: Book, callback: Callback< Book > )
    fun deleteBook( id: String, callback: Callback< String > )
}