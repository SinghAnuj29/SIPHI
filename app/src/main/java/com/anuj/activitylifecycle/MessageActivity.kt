package com.anuj.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MessageActivity : AppCompatActivity() {

    var displayText: String? = "Hello, How are you"
    lateinit var txtDisplay: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        txtDisplay = findViewById(R.id.txtDisplay)

        if(intent != null) {
            displayText = intent.getStringExtra("Display")
        }
        txtDisplay.text = displayText

        title = "Display Text"
    }
}