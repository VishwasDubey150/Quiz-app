package com.example.quiz

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private  var mcurrentPosition:Int=1
    private var mQuestionList:ArrayList<Question>?=null
    private var mSelectedOptionPosition:Int =0

    private  var progressBar:ProgressBar?=null
    private var iv_image:ImageView?=null


    private var pb_tv:TextView?=null
    private var opt1:TextView?=null
    private var opt2:TextView?=null
    private var opt3:TextView?=null
    private var opt4:TextView?=null
    private var Submit:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.questionsactivity)
        supportActionBar!!.hide()

        progressBar=findViewById<ProgressBar>(R.id.progressBar)
        pb_tv=findViewById<TextView>(R.id.pg_tv)
        iv_image=findViewById<ImageView>(R.id.iv_image)
        opt1=findViewById<TextView>(R.id.opt1)
        opt2=findViewById<TextView>(R.id.opt2)
        opt3=findViewById<TextView>(R.id.opt3)
        opt4=findViewById<TextView>(R.id.opt4)
        Submit=findViewById<Button>(R.id.Submit)

        opt1?.setOnClickListener(this)
        opt2?.setOnClickListener(this)
        opt3?.setOnClickListener(this)
        opt4?.setOnClickListener(this)

        Submit?.setOnClickListener(this)


        mQuestionList=constants.getQuestions()
        setQuestion()
        defaultOptionsView()

    }

    private fun setQuestion() {

        val question: Question = mQuestionList!![mcurrentPosition - 1]
        iv_image!!.setImageResource(question.image)
        progressBar!!.progress = mcurrentPosition
        pb_tv!!.text = "${mcurrentPosition - 1}/${progressBar?.max}"
        opt1!!.text = question.optionone
        opt2!!.text = question.optiontwo
        opt3!!.text = question.optionThree
        opt4!!.text = question.optionFour

        if(mcurrentPosition==mQuestionList!!.size)
        {
            Submit!!.text="Finish"
        }
        else
        {
            Submit!!.text="Submit"
        }
    }
    private fun defaultOptionsView()
    {
        val options=ArrayList<TextView>()
        opt1!!.let { options.add(0,it) }
        opt2!!.let { options.add(1,it) }
        opt3!!.let { options.add(2,it) }
        opt4!!.let { options.add(3,it) }

        for (option in options)
        {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,R.drawable.tv_bg)
        }
    }

    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int)
    {
        defaultOptionsView()

        mSelectedOptionPosition=selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
            this,R.drawable.selected_opt
        )

    }

    override fun onClick(view:View?) {
        when (view?.id)
        {
            R.id.opt1 -> {
            opt1?.let {
                selectedOptionView(it, 1)
            }
        }


            R.id.opt2 -> {
            opt2?.let {
                selectedOptionView(it, 2)
            }
        }

            R.id.opt3 -> {
                opt3?.let {
                    selectedOptionView(it, 3)
                }
            }

            R.id.opt4 -> {
                opt4?.let {
                    selectedOptionView(it, 4)
                }
            }

            R.id.Submit ->
            {

            }
        }
    }
}