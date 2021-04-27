package com.example.fragmentquestions.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fragmentquestions.R
import com.example.fragmentquestions.fragments.QuestionFragment
import com.example.fragmentquestions.models.Supplier
import kotlin.collections.ArrayList

class QuestionActivity : AppCompatActivity() {

    var nr_intrebari = 0
    var listOfChosenQuestions = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        val bundle: Bundle? = intent.extras
        nr_intrebari = bundle!!.get("nr_intrebari").toString().toInt()
        for(i in 0.rangeTo(Supplier.questions.size - 1))
            listOfChosenQuestions.add(0)
        listOfChosenQuestions[0] = bundle.get("cod_intrebari_1").toString().toInt()
        listOfChosenQuestions[1] = bundle.get("cod_intrebari_2").toString().toInt()
        listOfChosenQuestions[2] = bundle.get("cod_intrebari_3").toString().toInt()
        listOfChosenQuestions[3] = bundle.get("cod_intrebari_4").toString().toInt()

        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, QuestionFragment()).commit()
    }
}