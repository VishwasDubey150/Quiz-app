package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class result_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        supportActionBar!!.hide()
    }
    fun end(view: android.view.View) {
        finishAffinity()
    }
}