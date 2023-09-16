package com.example.markettesting

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.markettesting.ui.login.LoginActivity
import com.example.markettesting.util.Prefs

class NavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_keranjang
            )
        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navView.setOnItemSelectedListener {

            if (it.itemId == R.id.navigation_notifications){
                val s = Prefs(this)
                if (s.getLogin()){
                    navController.navigate(it.itemId)
                    Log.d("TAG","onCreate:Login")
                } else{
                    startActivity(Intent(this,LoginActivity::class.java))
                    Log.d("TAG","onCreate:belum")
                }
            } else {
                navController.navigate(it.itemId)
                Log.d("TAG","onCreate:notif"+it.itemId)
            }
            return@setOnItemSelectedListener true
        }
    }
}