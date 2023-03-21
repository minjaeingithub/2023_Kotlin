package com.example.week4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(val context:Context, val items:ArrayList<Restaurant>): BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items.get(position)
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(i:Int, cvtView: View?, parent:ViewGroup?): View {
        val inflater: LayoutInflater =
            LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.item, null)

        var imgView = view.findViewById<ImageView>(R.id.imageView)
        var textView = view.findViewById<TextView>(R.id.textView)

        textView.setText(items.get(i).name)
        imgView.setImageResource(items.get(i).id)

        return view
    }
}