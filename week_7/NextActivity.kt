package edu.skku.cs.week_6

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class NextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)
        val desc = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
        val hour = intent.getIntExtra(MainActivity.EXTRA_HOUR, -1)
        val mins = intent.getIntExtra(MainActivity.EXTRA_MINUTES, -1)

        val textView = findViewById<TextView>(R.id.textView)
        textView.text = "Do you want to set alarm on time ${hour} : ${mins} with description ${desc}?"

        var cancelBtn = findViewById<Button>(R.id.cancelBtn)
        cancelBtn.setOnClickListener {
            this.finish()
        }

        var okayBtn = findViewById<Button>(R.id.okayBtn)
        okayBtn.setOnClickListener {
            //implicit intent
            //check alarm app opens and alarm set
            val i = Intent(AlarmClock.ACTION_SET_ALARM)
            i.putExtra(AlarmClock.EXTRA_MESSAGE, desc)
            i.putExtra(AlarmClock.EXTRA_HOUR, hour)
            i.putExtra(AlarmClock.EXTRA_MINUTES, mins)
            startActivity(i)
        }
    }
    override fun onRestart(){
        super.onRestart()
        this.finish()
    }
}