package com.anuj.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AvengersAcitivity : AppCompatActivity() {

    var titleName: String? = "Avengers"

    lateinit var etDisplayText: EditText
    lateinit var btnSend: Button
    lateinit var btnLogout: Button

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name),Context.MODE_PRIVATE)

        setContentView(R.layout.activity_avengers)

        titleName = sharedPreferences.getString("Title", "The Avengers")
        title = titleName

        etDisplayText = findViewById(R.id.etDisplayText)
        btnSend = findViewById(R.id.btnSend)

        btnLogout = findViewById(R.id.btnLogout)

        btnSend.setOnClickListener {

            val displayText = etDisplayText.text.toString()
            val intent = Intent(this@AvengersAcitivity,MessageActivity::class.java)
            intent.putExtra("Display", displayText)
            startActivity(intent)
        }

        btnLogout.setOnClickListener {
            startActivity(Intent(this@AvengersAcitivity, LoginActivity::class.java))
            sharedPreferences.edit().clear().apply()
            finish()
        }
    }
}

//We can add the logout feature present in andrid studio projects folder --> ActivityLifecycle