package com.soyaaroncervantes.proyectofinalbasico.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Book(
  val name: String,
  val author: String,
  val pages: Int,
  val publishingHouse: String,
  val edition: Int,
  val resume: String,
  val website: String,
  val image: String,
  var id: String
  ) : Parcelable {
  constructor() : this("", "", 0, "", 1, "", "", "", "" )
}
