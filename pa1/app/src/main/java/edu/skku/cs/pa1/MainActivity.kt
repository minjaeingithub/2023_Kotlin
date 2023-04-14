package edu.skku.cs.pa1

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private fun readFile(fileName: String): String {
        return applicationContext.assets.open(fileName).use { inputStream ->
            val bytes = inputStream.readBytes()
            val fileContent = bytes.toString(Charsets.UTF_8)
            fileContent.lineSequence().joinToString(" ") { line ->
                line.uppercase()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wordList = readFile("wordle_words.txt").split(" ")
        val answer = wordList.random()
        println("${wordList.size} ${wordList.indexOf(answer)} $answer")

        val editText = findViewById<EditText>(R.id.input)

        val greyWordleLetterAdapter =
            WordLetterAdapter(Color.parseColor("#787C7E"), Color.parseColor("#FFFFFF"))
        val yellowWordleLetterAdapter =
            WordLetterAdapter(Color.parseColor("#FFE46F"), Color.parseColor("#000000"))
        val greenWordleLetterAdapter =
            WordLetterAdapter(Color.parseColor("#99F691"), Color.parseColor("#000000"))

        val wordleListAdapter = WordListAdapter(answer)

        findViewById<RecyclerView>(R.id.rcv_grey).adapter = greyWordleLetterAdapter
        findViewById<RecyclerView>(R.id.rcv_yellow).adapter = yellowWordleLetterAdapter
        findViewById<RecyclerView>(R.id.rcv_green).adapter = greenWordleLetterAdapter
        findViewById<RecyclerView>(R.id.rcv_middle).adapter = wordleListAdapter

        findViewById<View>(R.id.submit_button).setOnClickListener {
            val input = editText.text.toString().uppercase()

            if (!wordList.contains(input)) {
                Toast.makeText(
                    this@MainActivity,
                    "Word '$input' not in directory!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                editText.setText("")
                wordleListAdapter.wordList.add(input)
                wordleListAdapter.notifyItemInserted(wordleListAdapter.wordList.size)

                input.forEachIndexed { i, char ->
                    val word = char.toString()

                    when {
                        wordleListAdapter.answer[i].toString() == word -> {
                            greenWordleLetterAdapter.wordList.apply {
                                if (!contains(word)) {
                                    add(word)
                                    greenWordleLetterAdapter.notifyItemInserted(size)
                                }
                            }
                            yellowWordleLetterAdapter.wordList.apply {
                                if (remove(word)) yellowWordleLetterAdapter.notifyDataSetChanged()
                            }
                        }
                        wordleListAdapter.answer.contains(word) -> {
                            yellowWordleLetterAdapter.wordList.apply {
                                if (!contains(word)) {
                                    add(word)
                                    yellowWordleLetterAdapter.notifyItemInserted(size)
                                }
                            }
                        }
                        else -> {
                            greyWordleLetterAdapter.wordList.apply {
                                if (!contains(word)) {
                                    add(word)
                                    greyWordleLetterAdapter.notifyItemInserted(size)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}