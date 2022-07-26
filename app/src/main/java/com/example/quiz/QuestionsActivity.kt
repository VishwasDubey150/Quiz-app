package com.example.quiz

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.AdaptiveIconDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {//to make textview clickable

    private var mcurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0

    private var progressBar: ProgressBar? = null
    private var iv_image: ImageView? = null
    private var pb_tv: TextView? = null
    private var opt1: TextView? = null
    private var opt2: TextView? = null
    private var opt3: TextView? = null
    private var opt4: TextView? = null
    private var Submit: Button? = null
    var mUsername: String? = null
    var mCorrectanswer: Int =0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.questionsactivity)

        mUsername=intent.getStringExtra(constants.USER_NAME)


        supportActionBar!!.hide()

        progressBar = findViewById<ProgressBar>(R.id.progressBar)
        pb_tv = findViewById<TextView>(R.id.pg_tv)
        iv_image = findViewById<ImageView>(R.id.iv_image)
        opt1 = findViewById<TextView>(R.id.opt1)
        opt2 = findViewById<TextView>(R.id.opt2)
        opt3 = findViewById<TextView>(R.id.opt3)
        opt4 = findViewById<TextView>(R.id.opt4)
        Submit = findViewById<Button>(R.id.Submit)

        opt1?.setOnClickListener(this)
        opt2?.setOnClickListener(this)
        opt3?.setOnClickListener(this)
        opt4?.setOnClickListener(this)

        Submit?.setOnClickListener(this)

        mQuestionList = constants.getQuestions()//to fectch data from constants file
        setQuestion()
        defaultOptionsView()

    }

    private fun setQuestion() {//to set the page according to the data

        defaultOptionsView()
        val question: Question = mQuestionList!![mcurrentPosition - 1]
        iv_image!!.setImageResource(question.image)
        progressBar!!.progress = mcurrentPosition
        pb_tv!!.text = "${mcurrentPosition - 1}/${progressBar?.max}"
        opt1!!.text = question.optionone
        opt2!!.text = question.optiontwo
        opt3!!.text = question.optionThree
        opt4!!.text = question.optionFour


        if (mcurrentPosition == mQuestionList!!.size) {
            Submit!!.text = "Finish"
        } else {
            Submit!!.text = "Submit"//(!! for nullable)
        }
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        opt1!!.let { options.add(0, it) }
        opt2!!.let { options.add(1, it) }
        opt3!!.let { options.add(2, it) }
        opt4!!.let { options.add(3, it) }

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.tv_bg)
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this, R.drawable.selected_opt
        )

    }

    override fun onClick(view: View?) {
        when (view?.id) {
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

            R.id.Submit -> {
                if (mSelectedOptionPosition==0)
                {
                    mcurrentPosition++

                    when
                    {
                        mcurrentPosition<=mQuestionList!!.size ->{
                            setQuestion()
                        }

                        else ->
                        {


                            val intent=Intent(this,result_activity::class.java)
                            intent.putExtra(constants.USER_NAME,mUsername)
                            intent.putExtra(constants.CORRECT_ANSWER,mCorrectanswer)
                            intent.putExtra(constants.TOTAL_QUESTION, mQuestionList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else {
                    val question = mQuestionList?.get(mcurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrongopt_bg)
                    }
                    else
                    {
                        mCorrectanswer++
                    }
                    answerView(question!!.correctAnswer, R.drawable.correctopt_bg)


                    if (mcurrentPosition == mQuestionList!!.size) {
                        Submit?.text = "Finish"
                    } else {
                        Submit?.text = "Next"
                    }
                    mSelectedOptionPosition = 0
                }

            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer)
        {
            1->{
                opt1?.background=ContextCompat.getDrawable(
                    this@QuestionsActivity,drawableView
                )
            }

            2->{
                opt2?.background=ContextCompat.getDrawable(
                    this@QuestionsActivity,drawableView
                )
            }
            3->{
                opt3?.background=ContextCompat.getDrawable(
                    this@QuestionsActivity,drawableView
                )
            }
            4->{
                opt4?.background=ContextCompat.getDrawable(
                    this@QuestionsActivity,drawableView
                )
            }
        }
    }
}
