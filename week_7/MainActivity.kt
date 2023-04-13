package edu.skku.cs.week_6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_MESSAGE = "extra string" //string
        const val EXTRA_HOUR = "" //int
        const val EXTRA_MINUTES = "" //int
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextTime = findViewById<EditText>(R.id.timeText)
        val editTextDesc = findViewById<EditText>(R.id.descriptText)

        val btnNewAct = findViewById<Button>(R.id.NextButton)
        btnNewAct.setOnClickListener {
            val msg = editTextDesc.text.toString()
            val hour = editTextTime.text.toString().split(":")[0].toInt()
            val min = editTextTime.text.toString().split(":")[1].toInt()

            val intent = Intent(this, NextActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, msg)
                putExtra(EXTRA_HOUR, hour)
                putExtra(EXTRA_MINUTES, min)
            }
            startActivity(intent)
        }
    }

    override fun onRestart() {
        super.onRestart()
        val editTextTime = findViewById<EditText>(R.id.timeText)
        val editTextDesc = findViewById<EditText>(R.id.descriptText)

        editTextTime.text.clear()
        editTextDesc.text.clear()
    }


}