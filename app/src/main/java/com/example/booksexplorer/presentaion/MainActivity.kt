package com.example.booksexplorer.presentaion

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.booksexplorer.R

class MainActivity : AppCompatActivity() {

    var navController: NavController? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Retrieve the NavHostFragment using the correct ID
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        // Get the NavController
         navController = navHostFragment.navController

        // Setup action bar with navController for back navigation
//        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {

        return navController!!.navigateUp() || super.onSupportNavigateUp()
    }

}