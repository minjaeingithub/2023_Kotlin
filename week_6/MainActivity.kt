package com.example.week_6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    companion object{
        const val NAME = "extra name"
        const val AGE = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextName = findViewById<EditText>(R.id.editTextTextPersonName)
        val editTextAge = findViewById<EditText>(R.id.editTextAge)

        val btnNewActivity = findViewById<Button>(R.id.buttonNewActivity)
        btnNewActivity.setOnClickListener {
            val name = editTextName.text.toString()
            val age = editTextAge.text.toString().toInt()

            val intent = Intent(this, NothingActivity::class.java).apply {
                putExtra(NAME, name)
                putExtra(AGE, age)
            }
            startActivity(intent)
        }
    }

    override fun onRestart() {
        super.onRestart()
        val editTextName = findViewById<EditText>(R.id.editTextTextPersonName)
        val editTextAge = findViewById<EditText>(R.id.editTextAge)

        editTextName.text.clear()
        editTextAge.text.clear()
    }
}