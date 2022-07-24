package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.close
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button_start:Button=findViewById(R.id.button_start)
        var Entername:EditText=findViewById(R.id.Entername)
        supportActionBar?.hide()
        button_start.setOnClickListener {
            if (Entername.text.isEmpty())
            {
                Toast.makeText(this,"Please Enter your name",Toast.LENGTH_SHORT).show()
            }
            else{
                val intent=Intent(this,QuestionsActivity::class.java)
                startActivity(intent)
                finish()

            }
        }
    }
}