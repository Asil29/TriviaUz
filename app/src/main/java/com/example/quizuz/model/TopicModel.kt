package com.example.quizuz.model

import java.io.Serializable

data class TopicModel(
    val title: String,
    val listOfQuestions: List<QuestionsModel>
): Serializable

data class QuestionsModel(
    val title: String,
    val image: Int?,
    val answerA: String,
    val answerB: String,
    val answerC: String,
    val answerD: String,
    var correctAnswer: String,
    var answerOfUser: String = " ",
    var questionNumber: Int = 0
): Serializable