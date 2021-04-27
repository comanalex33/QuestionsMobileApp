package com.example.fragmentquestions.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fragmentquestions.R
import com.example.fragmentquestions.models.Supplier
import kotlinx.android.synthetic.main.activity_category.*

class CategoryActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        var nr_intrebari = 0

        var lista = ArrayList<Int>()
        for(i in 0.rangeTo(Supplier.questions.size - 1))
            lista.add(0)

        btn_startQuiz.setOnClickListener {
            if(rb_choose1.isChecked)
                lista[0] = 1
            if(rb_choose2.isChecked)
                lista[1] = 1
            if(rb_choose3.isChecked)
                lista[2] = 1
            if(rb_choose4.isChecked)
                lista[3] = 1
            if(!rb_choose1.isChecked && !rb_choose2.isChecked && !rb_choose3.isChecked && !rb_choose4.isChecked)
                Toast.makeText(this, "Nu ati selectat nicio categrie inca",Toast.LENGTH_SHORT).show()
            else if(nr_intrebari == 0) {
                Toast.makeText(this, "Nu ati introdus niciun numar de intrebari inca",Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this, QuestionActivity::class.java)
                intent.putExtra("cod_intrebari_1",lista[0])
                intent.putExtra("cod_intrebari_2",lista[1])
                intent.putExtra("cod_intrebari_3",lista[2])
                intent.putExtra("cod_intrebari_4",lista[3])
                if(nr_intrebari <= getMaxNumberOfQuestions(lista)) {
                    intent.putExtra("nr_intrebari", nr_intrebari)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "Nu exista atat de multe intrebari in baza de date", Toast.LENGTH_SHORT).show()
                }
            }
        }

        //Alegere numar intrebari
        var spin = findViewById(R.id.spinner_id) as Spinner

        val numbers = arrayOf(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)
        val ArrayAdap = ArrayAdapter<Int>(this, android.R.layout.simple_list_item_1, numbers)
        spin.adapter = ArrayAdap

        spin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                nr_intrebari = numbers[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

    }

    private fun getMaxNumberOfQuestions(listOfQuestions: ArrayList<Int>): Int{
        var s = 0
        for(i in 0.rangeTo(listOfQuestions.size - 1))
            if(listOfQuestions[i] == 1)
                s += Supplier.questions[i].size
        return s
    }


}