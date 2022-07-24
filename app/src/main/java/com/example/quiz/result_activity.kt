package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class result_activity : AppCompatActivity() {

    private var username:TextView?=null
    private var marks:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        supportActionBar!!.hide()

        username=findViewById(R.id.username)
        marks=findViewById(R.id.marks)

        username?.text= intent.getStringExtra(constants.USER_NAME)
        val totalmarks=intent.getIntExtra(constants.CORRECT_ANSWER,0)
        val totalquestion=intent.getIntExtra(constants.TOTAL_QUESTION,0)
        marks?.text="You got ${totalmarks} out of ${totalquestion}"

    }
    fun end(view: android.view.View) {
        finishAffinity()
    }
}