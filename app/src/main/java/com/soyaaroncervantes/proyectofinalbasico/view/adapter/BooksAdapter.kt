package com.soyaaroncervantes.proyectofinalbasico.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.soyaaroncervantes.proyectofinalbasico.R
import com.soyaaroncervantes.proyectofinalbasico.model.Book

class BooksAdapter(private val booksListener: BooksListener) :
  RecyclerView.Adapter<BooksAdapter.ViewHolder>() {
  private val books = arrayListOf<Book>()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
    ViewHolder(LayoutInflater.from( parent.context ).inflate( R.layout.item_book, parent, false ) )

  override fun getItemCount(): Int = books.size

  override fun onBindViewHolder( viewHolder: ViewHolder, position: Int) {

    val book = books[position]

    viewHolder.textViewTitleBook.text = book.name
    viewHolder.textViewPagesBook.text = book.pages.toString()
    viewHolder.textViewAuthorBook.text = book.author

    viewHolder.itemView.setOnClickListener {
      booksListener.onBookClick( book, position )
    }

  }

  fun updateData(data: List<Book>) {
    books.clear();
    books.addAll(data)
    notifyDataSetChanged()
  }

  class ViewHolder( itemView: View ) : RecyclerView.ViewHolder( itemView ) {
    val textViewTitleBook: TextView =   itemView.findViewById( R.id.textViewTitleBook )
    val textViewAuthorBook: TextView =  itemView.findViewById( R.id.textViewAuthorBook )
    val textViewPagesBook: TextView =   itemView.findViewById( R.id.textViewPagesBook )
  }
}