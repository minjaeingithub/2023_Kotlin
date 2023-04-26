package edu.skku.cs.week9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.w3c.dom.Text
import kotlin.math.pow
import kotlin.math.sqrt


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView)
        button.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch(){
                textView.text = longTask().await()
            }
        }
    }

    fun longTask() = CoroutineScope(Dispatchers.Default).async{
        var totalCount = 0
        var innerCount = 0
        for(bigLoop in 1..100){
            for(smallLoop in 1..1_000_000) {
                val x = Math.random()
                val y = Math.random()
                val sum = sqrt(x.pow(2) + y.pow(2))
                if (sum <= 1) innerCount+=1
                totalCount += 1
            }
            val currentValue = (innerCount.toDouble() / totalCount.toDouble()) * 4f
            CoroutineScope(Dispatchers.Main).launch{
                val textView = findViewById<TextView>(R.id.textView)
                textView.text = "Done ${bigLoop}%...\n" +
                    "current estimation: ${String.format("%.6f", currentValue)}"
            }
        }
        val lastValue = (innerCount.toDouble() / totalCount.toDouble()) * 4.0f
            "Done!\nEstimation: ${String.format("%.6f", lastValue.toDouble())}"
    }
}