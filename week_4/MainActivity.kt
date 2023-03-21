package com.example.week4

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var linearLayout = findViewById<LinearLayout>(R.id.sub_layout)
        var sub_btn = findViewById<Button>(R.id.button)
        var btn1 = findViewById<Button>(R.id.button1)
        var btn2 = findViewById<Button>(R.id.button2)
        var btn3 = findViewById<Button>(R.id.button3)

        var chickens = arrayListOf<Restaurant>()
        var pizzas = arrayListOf<Restaurant>()
        var hamburgers = arrayListOf<Restaurant>()
        //치킨
        chickens.add(Restaurant(R.drawable.bbq, "bbq"))
        chickens.add(Restaurant(R.drawable.bhc, "bhc"))
        chickens.add(Restaurant(R.drawable.pizzanarachickengongju, "pizza nara chicken gongju"))
        chickens.add(Restaurant(R.drawable.goobne, "goobne"))
        //피자
        pizzas.add(Restaurant(R.drawable.pizzanarachickengongju, "pizza nara chicken gongju"))
        pizzas.add(Restaurant(R.drawable.pizzahut, "pizzahut"))
        pizzas.add(Restaurant(R.drawable.domino, "domino"))
        //햄버거
        hamburgers.add(Restaurant(R.drawable.mcdonalds, "mcdonalds"))
        hamburgers.add(Restaurant(R.drawable.lotteria, "lotteria"))
        hamburgers.add(Restaurant(R.drawable.burgerking, "burgerking"))
        hamburgers.add(Restaurant(R.drawable.momstouch, "momstouch"))

        val layoutInflater:LayoutInflater =
            applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        layoutInflater.inflate(R.layout.sub_layout, linearLayout, true)

        sub_btn.setOnClickListener {
            var img1 = findViewById<ImageView>(R.id.imageView)
            var img2 = findViewById<ImageView>(R.id.imageView2)

            img1.setImageResource(R.drawable.bbq)
            img2.setImageResource(R.drawable.bhc)
        }
        btn1.setOnClickListener {
            //치킨
            val listAdaptor1 = CustomAdapter(this, chickens)
            var mainList1 = findViewById<ListView>(R.id.listview)
            mainList1.adapter = listAdaptor1
        }

        btn2.setOnClickListener {
            val listAdaptor2 = CustomAdapter(this, pizzas)
            var mainList2 = findViewById<ListView>(R.id.listview)
            mainList2.adapter = listAdaptor2
        }

        btn3.setOnClickListener {
            val listAdaptor3 = CustomAdapter(this, hamburgers)
            var mainList3 = findViewById<ListView>(R.id.listview)
            mainList3.adapter = listAdaptor3
        }
    }
}
