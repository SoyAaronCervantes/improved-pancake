package com.soyaaroncervantes.proyectofinalbasico.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.soyaaroncervantes.proyectofinalbasico.R
import com.soyaaroncervantes.proyectofinalbasico.model.Book

class BookAdapter( private val bookListener: BookListener ): RecyclerView.Adapter< BookAdapter.ViewHolder >() {
  private val books = arrayListOf<Book>()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder( LayoutInflater
      .from( parent.context )
      .inflate( R.layout.item_book, parent, false ) )

  override fun getItemCount(): Int = books.size

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val book = books[ position ]
  }

  class ViewHolder( itemView: View): RecyclerView.ViewHolder( itemView ) {

  }
}