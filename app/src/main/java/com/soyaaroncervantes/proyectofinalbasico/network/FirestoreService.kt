package com.soyaaroncervantes.proyectofinalbasico.network

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.firestore.ktx.toObjects
import com.soyaaroncervantes.proyectofinalbasico.model.Book

const val BookCollectionName = "books"

class FirestoreService: BookCRUD {
    private val firebaseFirestore = FirebaseFirestore.getInstance()
    private val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()
    private val bookCollectionFirestore = firebaseFirestore.collection( BookCollectionName )

    init {
        firebaseFirestore.firestoreSettings = settings
    }

    override fun addBook( book: Book, callback: Callback< Book > ) {
        bookCollectionFirestore
            .document()
            .set( book )
            .addOnSuccessListener {
                callback.onSuccess( book )
            }
    }

    override fun getBooks( callback: Callback< ArrayList<Book> >) {
        bookCollectionFirestore
            .get()
            .addOnSuccessListener { querySnapshot ->
                for ( document in querySnapshot ) {
                    val list = querySnapshot.toObjects<Book>() as ArrayList<Book>
                    callback.onSuccess( list )
                    break
                }
            }
    }

    override fun getBook( id: String, callback: Callback< Book >) {
        bookCollectionFirestore
            .document( id )
            .get()
            .addOnSuccessListener { documentSnapshot ->
                val book = documentSnapshot.toObject<Book>() ?: Book()
                callback.onSuccess( book )
            }
    }

    override fun updateBook( book: Book, callback: Callback< Book > ) {
        bookCollectionFirestore
            .document( book.id )
            .set( book, SetOptions.merge() )
            .addOnSuccessListener{
                callback.onSuccess( book )
            }

    }

    override fun deleteBook( id: String, callback: Callback< String > ) {
        bookCollectionFirestore
            .document( id )
            .delete()
            .addOnSuccessListener{
                callback.onSuccess( id )
            }
    }


}