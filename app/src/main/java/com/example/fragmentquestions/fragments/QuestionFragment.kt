package com.example.fragmentquestions.fragments

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast

import com.example.fragmentquestions.R
import com.example.fragmentquestions.activities.FinishActivity
import com.example.fragmentquestions.activities.QuestionActivity
import com.example.fragmentquestions.models.Question
import com.example.fragmentquestions.models.Supplier
import kotlinx.android.synthetic.main.fragment_question.view.*
import kotlin.random.Random

/**
 * A simple [Fragment] subclass.
 */
class QuestionFragment : Fragment() {

    var counter = 1

    companion object{
        var correct = 0
        var wrong = 0
    }

    lateinit var questions: List<Question>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_question, container, false)

        arguments?.apply {
            counter = arguments!!.getInt("counter")
        }

        //Toast.makeText(activity, "$correct $wrong", Toast.LENGTH_SHORT).show()

        var contextQuestions = activity as QuestionActivity

        do{
            var index = Random.nextInt(0,Supplier.questions.size)
            when(index) {
                0 -> questions = Supplier.questions[0]
                1 -> questions = Supplier.questions[1]
                2 -> questions = Supplier.questions[2]
                3 -> questions = Supplier.questions[3]
                else -> questions = listOf()
            }
        }while(contextQuestions.listOfChosenQuestions[index] == 0 || !existQuestionsNotChosen(Supplier.questions[index]))

        generateQuestions(view, contextQuestions.nr_intrebari, questions, contextQuestions.listOfChosenQuestions)

        return view
    }

    private fun generateQuestions(view: View, nr_intrebari: Int, questions: List<Question>, listOfChosenQuestions: ArrayList<Int>) {

        var index: Int
        do {
            index = Random.nextInt(0,questions.size)
        }while(questions[index].choosed)
        questions[index].choosed = true

        view.questionText.text = questions[index].text

        view.rb1.text = questions[index].options[0]
        view.rb2.text = questions[index].options[1]
        view.rb3.text = questions[index].options[2]
        view.rb4.text = questions[index].options[3]

        view.buttonQuestion.setOnClickListener {
            if(!view.rb1.isChecked && !view.rb2.isChecked && !view.rb3.isChecked && !view.rb4.isChecked)
                Toast.makeText(activity,"Trebuie sa alegeti un raspuns",Toast.LENGTH_SHORT).show()
            else
                if(condition(view.rb1, index, questions)){
                    correct++
                    view.rb1.setBackgroundColor(Color.GREEN)
                    make(view.buttonQuestion, nr_intrebari, listOfChosenQuestions)
                }
                else if(condition(view.rb2, index, questions)){
                    correct++
                    view.rb2.setBackgroundColor(Color.GREEN)
                    make(view.buttonQuestion, nr_intrebari, listOfChosenQuestions)
                }
                else if(condition(view.rb3, index, questions)){
                    correct++
                    view.rb3.setBackgroundColor(Color.GREEN)
                    make(view.buttonQuestion, nr_intrebari, listOfChosenQuestions)
                }
                else if(condition(view.rb4, index, questions)){
                    correct++
                    view.rb4.setBackgroundColor(Color.GREEN)
                    make(view.buttonQuestion, nr_intrebari, listOfChosenQuestions)
                }
                else {
                    wrong++
                    correctAnswer(view, index, questions)
                    make(view.buttonQuestion, nr_intrebari, listOfChosenQuestions)
                }
        }
    }

    private fun condition(rb: RadioButton, index: Int, questions: List<Question>): Boolean {
        return rb.isChecked && rb.text.equals(questions[index].answer)
    }

    private fun make(button: Button, nr_intrebari: Int, listOfChosenQuestions: ArrayList<Int>) {
        button.text = "Next"
        button.setOnClickListener {
            if (counter != nr_intrebari) {
                val bundle = Bundle()
                bundle.putInt("counter", counter + 1)
                val fragment = QuestionFragment()
                fragment.arguments = bundle
                fragmentManager!!.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
            } else {
                counter = 0
                val intent = Intent(activity, FinishActivity::class.java)
                intent.putExtra("correct_answers", correct)
                intent.putExtra("wrong_answers", wrong)
                correct = 0
                wrong = 0
                uncheckChosenQuestions(listOfChosenQuestions)
                startActivity(intent)
            }
        }
    }

    private fun uncheckChosenQuestions(listOfChosenQuestions: ArrayList<Int>) {
        for(i in 0.rangeTo(listOfChosenQuestions.size - 1))
            if(listOfChosenQuestions[i] == 1)
                for(j in 0.rangeTo(Supplier.questions[i].size - 1))
                    Supplier.questions[i][j].choosed = false
    }

    private fun correctAnswer(view: View, index: Int, questions: List<Question>) {
        //Green backround for correct answer
        if(view.rb1.text.equals(questions[index].answer))
            view.rb1.setBackgroundColor(Color.GREEN)
        else if(view.rb2.text.equals(questions[index].answer))
            view.rb2.setBackgroundColor(Color.GREEN)
        else if(view.rb3.text.equals(questions[index].answer))
            view.rb3.setBackgroundColor(Color.GREEN)
        else
            view.rb4.setBackgroundColor(Color.GREEN)

        //Red backround for wrong answer
        if(view.rb1.isChecked)
            view.rb1.setBackgroundColor(Color.RED)
        else if(view.rb2.isChecked)
            view.rb2.setBackgroundColor(Color.RED)
        else if(view.rb3.isChecked)
            view.rb3.setBackgroundColor(Color.RED)
        else
            view.rb4.setBackgroundColor(Color.RED)
    }

    private fun existQuestionsNotChosen(questions: List<Question>): Boolean{
        for(i in 0.rangeTo(questions.size - 1))
            if(questions[i].choosed == false)
                return true
        return false
    }
}
