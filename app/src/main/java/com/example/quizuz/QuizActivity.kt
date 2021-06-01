package com.example.quizuz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.quizuz.model.TopicModel
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

    private lateinit var questions: TopicModel
    private var index: Int = 0
    private var correctAnswers: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        quiz_back_button.setOnClickListener {
            finish()
        }


        questions = intent.getSerializableExtra("Extra") as TopicModel

        setQuestions()

        button_a.setOnClickListener {

            if (index <= questions.listOfQuestions.size-1) {
                questions.listOfQuestions[index].answerOfUser = "A"
                if (questions.listOfQuestions[index].correctAnswer == "A") {
                    correctAnswers++
                }
            }

            index++
            setQuestions()
        }
        button_b.setOnClickListener {

            if (index <= questions.listOfQuestions.size-1) {
                questions.listOfQuestions[index].answerOfUser = "B"
                if (questions.listOfQuestions[index].correctAnswer == "B") {
                    correctAnswers++
                }
            }
            index++
            setQuestions()
        }
        button_c.setOnClickListener {

            if (index <= questions.listOfQuestions.size-1) {
                questions.listOfQuestions[index].answerOfUser = "C"
                if (questions.listOfQuestions[index].correctAnswer == "C") {
                    correctAnswers++
                }
            }

            index++
            setQuestions()
        }
        button_d.setOnClickListener {
            if (index <= questions.listOfQuestions.size-1) {
                questions.listOfQuestions[index].answerOfUser = "D"
                if (questions.listOfQuestions[index].correctAnswer == "D") {
                    correctAnswers++
                }
            }
            index++
            setQuestions()
        }
    }

    private fun setQuestions(){

        if (index < questions.listOfQuestions.count()){
            val question = questions.listOfQuestions[index]
            question.questionNumber = index + 1
            question_title.text = question.title
            if (question.image != null){
                question_image.visibility = View.VISIBLE
                question_image.setImageResource(question.image)
            }else{
                question_image.visibility = View.GONE
            }

            button_a.text = question.answerA
            button_b.text = question.answerB
            button_c.text = question.answerC
            button_d.text = question.answerD
        }else{
            val intent = Intent(this, ResultsActivity::class.java)
            intent.putExtra("result", questions)
            startActivity(intent)
        }
    }
}