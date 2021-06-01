package com.example.quizuz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quizuz.model.TopicModel
import kotlinx.android.synthetic.main.activity_results.*

class ResultsActivity : AppCompatActivity() {
    private lateinit var items: TopicModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)


        imgBack.setOnClickListener {
            finish()
        }

        items = intent.getSerializableExtra("result") as TopicModel

        tvTitle.text = items.title

        var reportText = ""

        var correctAnswerCount = 0

        items.listOfQuestions.forEachIndexed { index, it ->
            if (it.answerOfUser != it.correctAnswer) {
                reportText += "${index + 1}.❌ Sizning javobingiz: ${it.answerOfUser}\n✅ Tog'ri javob: ${it.correctAnswer}\n"

            } else {
                correctAnswerCount++
                reportText += "${index + 1}. ✅  ${it.correctAnswer}\n"
            }
//
        }

        tvReport.text = reportText

        val progress: Float = (100f/items.listOfQuestions.count()) * correctAnswerCount
        progress_tv.text = "${String.format("%.1f", progress)}%"
        circular_determinative_pb.progress = progress.toInt()

    }

}