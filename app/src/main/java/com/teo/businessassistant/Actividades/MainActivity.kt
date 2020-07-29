package com.teo.businessassistant.Actividades

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.teo.businessassistant.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

         navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_clientes,
            R.id.navigation_listInventario,
            R.id.navigation_compras
        ))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        setBottomNavVisibility()
    }

    /******************************************************************************************************************/
    /***************//*Función para ocultar el buttom navigation al pasar a un fragmento anidado*//********************/
    /******************************************************************************************************************/

    private fun setBottomNavVisibility(){

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when(destination.id){
                R.id.navigation_nuevoElemento -> hideBottomNav() /*******Aquí solo lo oculta estando en nuevo elemento****/
                else -> showBottomNav()
            }
            when(destination.id){
                R.id.navigation_nuevoCliente -> hideBottomNav() /*******Aquí solo lo oculta estando en nuevo cliente****/
                else -> showBottomNav()
            }
        }
    }

    private fun showBottomNav(){
        nav_view.visibility = View.VISIBLE
    }

    private fun hideBottomNav(){
        nav_view.visibility = View.GONE
    }

    /*********Ir atras con la flechita***********/
    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp()
    }

}