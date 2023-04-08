package com.example.week_6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class NothingActivity : AppCompatActivity() {
    companion object{
        const val NAME = "extra name"
        const val AGE = ""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nothing)

        val name = intent.getStringExtra(MainActivity.NAME)
        val sid = intent.getIntExtra(MainActivity.AGE, -1)

        val yesButton = findViewById<Button>(R.id.YesButton)
        val noButton = findViewById<Button>(R.id.NoButton)

        val textDisplay = findViewById<TextView>(R.id.Verification)

        textDisplay.text = "You typed name ${name} and age ${sid}, is that right? "
        yesButton.setOnClickListener {
            val intent = Intent(this, LastActivity::class.java).apply {
                putExtra(MainActivity.NAME, name)
                putExtra(MainActivity.AGE, sid)
            }
            startActivity(intent)
        }

        noButton.setOnClickListener {
            finish()
        }
    }

}