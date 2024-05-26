package com.example.caps1stfan_quiz

import kotlin.random.Random

data class QuizQuestion (
    val question: String, // String value that includes a trivia question
    val options: List<String>, // List of strings that include possible answers
    val correctAnswer: Int // Int value that is tied to the index of the answer
)

class Quiz {
fun getQuestion(): QuizQuestion {
    val randomIndex = Random.nextInt(quizQuestions.size)
    return quizQuestions[randomIndex]
}


// Most questions and answers provided by ChatGPT
val quizQuestions = listOf( // List of quiz questions
    QuizQuestion(
        question = "When is Captain America's birthday?",
        options = listOf("May 1", "December 20", "June 23", "July 4"),
        correctAnswer = 3
    ),
    QuizQuestion(
        question = "In which comic book did Captain America make his first appearance?",
        options = listOf("Tales of Suspense #39", "Captain America Comics #1", "The Amazing Spider-Man #12", "The Avengers #4"),
        correctAnswer = 1
    ),
    QuizQuestion(
        question = "Who created the character of Captain America?",
        options = listOf("Stan Lee and Steve Ditko", "Jerry Siegel and Joe Shuster", "Bob Kane and Bill Finger", "Joe Simon and Jack Kirby"),
        correctAnswer = 4
    ),
    QuizQuestion(
        question = "Which super soldier serum was Steve Rogers injected with to become Captain America?",
        options = listOf("Erskine Serum", "Stark Formula", "Banner's Blood", "Mutant Growth Hormone"),
        correctAnswer = 0
    ),
    QuizQuestion(
        question = "What tragic event motivates Steve Rogers to become Captain America?",
        options = listOf("The death of his parents", "The bombing of Pearl Harbor", "The attack on New York City", "The destruction of his art school"),
        correctAnswer = 1
    ),
    QuizQuestion(
        question = "In the Marvel Cinematic Universe, which movie first featured Captain America?",
        options = listOf("Iron Man", "Captain America: The First Avenger", "The Avengers", "Thor"),
        correctAnswer = 4
    ),
)}