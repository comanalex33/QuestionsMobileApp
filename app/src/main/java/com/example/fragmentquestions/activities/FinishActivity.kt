package com.example.fragmentquestions.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.fragmentquestions.R
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity: AppCompatActivity() {

    lateinit var goStart : Button
    lateinit var textViewCorrect : TextView
    lateinit var textViewWrong : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        goStart = findViewById(R.id.button_start_activity)
        textViewCorrect = findViewById(R.id.tv_correct)
        textViewWrong = findViewById(R.id.tv_wrong)

        val bundle : Bundle? = intent.extras
        textViewCorrect.text = "Raspunsuri corecte : ${bundle!!.getInt("correct_answers").toString()}"
        textViewWrong.text = "Raspunsuri gresite : ${bundle!!.getInt("wrong_answers").toString()}"

        goStart.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}