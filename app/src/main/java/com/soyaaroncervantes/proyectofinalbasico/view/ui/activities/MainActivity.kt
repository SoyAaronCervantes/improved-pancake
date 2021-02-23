package com.soyaaroncervantes.proyectofinalbasico.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.soyaaroncervantes.proyectofinalbasico.R

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    configNavigation()
  }

  private fun configNavigation() {
    val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContent) as NavHostFragment
    val navController = navHostFragment.navController

    NavigationUI.setupWithNavController( findViewById<BottomNavigationView>( R.id.bottomNavigationMenu ), navController )
  }
}