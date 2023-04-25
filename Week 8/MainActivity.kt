package edu.skku.cs.week_8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import edu.skku.cs.week_8.databinding.ActivityMainBinding
import splitties.toast.toast


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Original Code
//        val btnBake = findViewById<Button>(R.id.buttonShowToast)
//        btnBake.setOnClickListener {
//            val editTextMsg = findViewById<EditText>(R.id.editTextToastMsg)
//            Toast.makeText(
//                this@MainActivity.applicationContext,
//                editTextMsg.text.toString(),
//                Toast.LENGTH_SHORT
//            ).show()
//        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonShowToast.setOnClickListener {
            toast(binding.editTextToastMsg.text.toString())
        }
    }
}