package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class QuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.questionsactivity)
        supportActionBar?.hide()

    }
}