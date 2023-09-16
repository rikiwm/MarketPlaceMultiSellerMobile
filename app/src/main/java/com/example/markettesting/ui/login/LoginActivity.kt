package com.example.markettesting.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import com.example.markettesting.R
import com.example.markettesting.util.Prefs
import kotlin.math.log


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val login = findViewById<Button>(R.id.login)
        val logout = findViewById<Button>(R.id.logout)
        val loading = findViewById<ProgressBar>(R.id.loading)

        val s = Prefs(this)
        if (s.getLogin()){
            login.text = "Sudah"
        } else {
            login.text = "Belum"
            login.setOnClickListener {
                s.setLogin(true)
                onBackPressed()
            }
            logout.setOnClickListener {
                s.setLogin(false)
                onBackPressed()
            }

        }


    }
}