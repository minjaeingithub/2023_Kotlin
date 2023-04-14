package edu.skku.cs.pa1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordLetterAdapter(private val bg_color: Int, private val textColor: Int) : RecyclerView.Adapter<WordLetterAdapter.WordLetterViewHolder>()
{
    var wordList: MutableList<String> = ArrayList()

    override fun getItemCount(): Int {
        return wordList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordLetterViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.word, parent, false)
        return WordLetterViewHolder(view)
    }

    override fun onBindViewHolder(holder: WordLetterViewHolder, position: Int) {
        holder.textView.apply {
            text = wordList[position]
            setBackgroundColor(bg_color)
            setTextColor(textColor)
        }
    }

    class WordLetterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.letter_after_check)
    }
}