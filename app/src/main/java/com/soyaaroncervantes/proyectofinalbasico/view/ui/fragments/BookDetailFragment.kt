package com.soyaaroncervantes.proyectofinalbasico.view.ui.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.soyaaroncervantes.proyectofinalbasico.R
import com.soyaaroncervantes.proyectofinalbasico.model.Book

class BookDetailFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle( STYLE_NORMAL, R.style.FullScreenDialogStyle )
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        return inflater.inflate(R.layout.fragment_book_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbarView = view.findViewById<Toolbar>( R.id.toolbarBookDetail )
        val book = arguments?.getParcelable<Book>("book")

        toolbarView.navigationIcon = ContextCompat.getDrawable( view.context, R.drawable.ic_close )
        toolbarView.setTitleTextColor( Color.WHITE )
        toolbarView.setNavigationOnClickListener { dismiss() }
        toolbarView.title = book?.name
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout( ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT )
    }
}