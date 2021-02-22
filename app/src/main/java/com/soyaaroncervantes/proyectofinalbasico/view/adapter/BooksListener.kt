package com.soyaaroncervantes.proyectofinalbasico.view.adapter

import com.soyaaroncervantes.proyectofinalbasico.model.Book

interface BooksListener {
  fun onBookClick( book: Book, position: Int )
}