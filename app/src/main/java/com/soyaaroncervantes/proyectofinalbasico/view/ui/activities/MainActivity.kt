package com.soyaaroncervantes.proyectofinalbasico.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.firestore.FirebaseFirestore
import com.soyaaroncervantes.proyectofinalbasico.R
import com.soyaaroncervantes.proyectofinalbasico.model.Book
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    configNavigation()
    // createBooksRaw()
  }

  private fun configNavigation() {
    val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContent) as NavHostFragment
    val navController = navHostFragment.navController

    NavigationUI.setupWithNavController( findViewById<BottomNavigationView>( R.id.bottomNavigationMenu ), navController )
  }

  // Create books raw to firestore
  /*
    NOTE:
    Refill information to each book, if you want to create new books
   */
  private fun createBooksRaw() {
    val firebaseFirestore = FirebaseFirestore.getInstance()

    val book1 = Book(
      "Crimen y Castigo",
      "Fyodor Dostoevsky",
      650,
      "Porrua",
      1,
      "La historia narra la vida de Rodión Raskólnikov, un estudiante en la capital de la Rusia Imperial, San Petersburgo. Este joven se ve obligado a suspender sus estudios por la miseria en la cual se ve envuelto, a pesar de los esfuerzos realizados por su madre Pulqueria y su hermana Dunia para enviarle dinero. Necesitado de financiación para pagar sus gastos, había recurrido a una anciana prestamista vil y egoísta, en cuya casa empeña algunos objetos de valor.",
      "https://www.amazon.com.mx/Crimen-Castigo-portada-puede-variar/dp/9700771482/ref=sr_1_7?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=15LO06II0PVK8&dchild=1&keywords=crimen+y+castigo&qid=1614696203&sprefix=crimen+%2Caps%2C272&sr=8-7",
      "https://images.cdn3.buscalibre.com/fit-in/360x360/57/f4/57f45dd845bc86570769166c970d9047.jpg",
      firebaseFirestore.collection("Books").document().id
    )
    val book2 = Book(
      "El final del circulo",
      "Tom Egeland",
      448,
      "Ediciones B",
      4,
      "Contratado por la Universidad de Oslo para supervisar unas excavaciones arqueológicas que se están llevando a cabo en el monasterio de Vaerne (Noruega), Björn Belto es testigo de un hallazgo único. Se trata de un cofre de más de dos mil años de antigüedad que contiene un manuscrito con una serie de leyendas. El descubrimiento podría modificar por completo la versión oficial de la historia del cristianismo.\n" +
              "\n" +
              "Belto, tratando de evitar que el cofre caiga en las innobles manos de unos tipos que se escudan en una fachada académica, huye del país nórdico e inicia un periplo que le llevará de Londres a Oriente Próximo. Perseguido por aquellos que quieren hacerse con el cofre, Belto recala finalmente en Rennes-le-Château, un pueblo del sur de Francia donde los hermanos custodios guardan celosamente un misterioso evangelio que pone en cuestión la propia biografía de Jesucristo.",
      "https://www.amazon.com/final-circulo-Latrama-Hardcover-Spanish/dp/846662371X",
      "https://www.uv.es/capelo/El_final_del_circulo.jpg",
      firebaseFirestore.collection("Books").document().id
    )

    firebaseFirestore.collection("books").document( book1.id ).set(book1)
    firebaseFirestore.collection("books").document( book2.id ).set(book2)
  }
}