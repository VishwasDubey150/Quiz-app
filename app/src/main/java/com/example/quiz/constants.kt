package com.example.quiz

object constants
{
    const val USER_NAME:String="user_name"
    const val TOTAL_QUESTION:String="total_question"
    const val CORRECT_ANSWER:String="correct_answer"

    fun getQuestions():ArrayList<Question>{
        val questionList=ArrayList<Question>()

        val que1=Question(
            1,"What country does this flag belong to?",
            R.drawable.australia,
            "England","USA",
            "Australia","China"
        ,3,
        )
        questionList.add(que1)

        val que2=Question(
            2,"What country does this flag belong to?",
            R.drawable.belgium,
            "Germany","Belgium",
            "Poland","Spain"
            ,2,
        )
        questionList.add(que2)

        val que3=Question(
            3,"What country does this flag belong to?",
            R.drawable.canada,
            "England","USA",
            "Australia","Canada"
            ,4,
        )
        questionList.add(que3)

        val que4=Question(
            4,"What country does this flag belong to?",
            R.drawable.france,
            "Ireland","Poland",
            "France","Italy"
            ,3,
        )
        questionList.add(que4)

        val que5=Question(
            5,"What country does this flag belong to?",
            R.drawable.germany,
            "Norway","France",
            "Belgium","Germany"
            ,4,
        )
        questionList.add(que5)

        val que6=Question(
            6,"What country does this flag belong to?",
            R.drawable.ireland,
            "Ireland","Norway",
            "India","Mexico"
            ,1,
        )
        questionList.add(que6)

        val que7=Question(
            7,"What country does this flag belong to?",
            R.drawable.netherlands,
            "Netherlands","USA",
            "Australia","UAE"
            ,1,
        )
        questionList.add(que7)

        val que8=Question(
            8,"What country does this flag belong to?",
            R.drawable.usa,
            "England","Argentina",
            "Australia","USA"
            ,4,
        )
        questionList.add(que8)
        val que9=Question(
            9,"What country does this flag belong to?",
            R.drawable.uae,
            "Oman","UAE",
            "Qatar","None of above"
            ,2,
        )
        questionList.add(que9)

        val que10=Question(
            10,"What country does this flag belong to?",
            R.drawable.uk,
            "England","USA",
            "Australia","China"
            ,1,
        )
        questionList.add(que10)


        return questionList
    }

}