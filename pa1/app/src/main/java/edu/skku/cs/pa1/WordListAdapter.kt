package edu.skku.cs.pa1

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordListAdapter(var answer: String) : RecyclerView.Adapter<WordListAdapter.WordListViewHolder>() {
    var wordList: MutableList<String> = ArrayList()

    //Recycler view에서는 from(parent.context)를 넣어줘야했었음
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.wordle_list, parent, false)
        return WordListViewHolder(view)
    }

    override fun onBindViewHolder(holder: WordListViewHolder, position: Int) {
        val greenColor = Color.parseColor("#99F691")
        val yellowColor = Color.parseColor("#FFE46F")
        val greyColor = Color.parseColor("#787C7E")
        val blackColor = Color.parseColor("#000000")
        val whiteColor = Color.parseColor("#FFFFFF")

        val currentWord = wordList[position]

        for (i in 0..4) {
            val letter = currentWord.substring(i, i + 1)
            holder.textViewList[i].text = letter

            when {
                answer.contains(letter) -> {
                    if (answer[i].toString() == letter) {
                        holder.textViewList[i].apply {
                            setBackgroundColor(greenColor)
                            setTextColor(blackColor)
                        }
                    } else {
                        holder.textViewList[i].apply {
                            setBackgroundColor(yellowColor)
                            setTextColor(blackColor)
                        }
                    }
                }
                else -> {
                    holder.textViewList[i].apply {
                        setBackgroundColor(greyColor)
                        setTextColor(whiteColor)
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return wordList.size
    }

    class WordListViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var textViewList: MutableList<TextView> = ArrayList()

        init {
            textViewList.add(itemView.findViewById(R.id.first_letter))
            textViewList.add(itemView.findViewById(R.id.second_letter))
            textViewList.add(itemView.findViewById(R.id.third_letter))
            textViewList.add(itemView.findViewById(R.id.fourth_letter))
            textViewList.add(itemView.findViewById(R.id.fifth_letter))
        }
    }
}