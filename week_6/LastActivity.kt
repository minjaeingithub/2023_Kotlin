package com.example.week_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class LastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last)

        val name = intent.getStringExtra(NothingActivity.NAME)
        val sid = intent.getIntExtra(NothingActivity.AGE, -1)
        Toast.makeText(
            applicationContext,
            "Welcome, ${name}(${sid} years old)!",
            Toast.LENGTH_SHORT
        ).show()
    }
}