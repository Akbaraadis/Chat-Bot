package com.project_akbar.chat_bot.utils

import com.project_akbar.chat_bot.utils.Constant.OPEN_GOOGLE
import com.project_akbar.chat_bot.utils.Constant.OPEN_SEARCH
import java.lang.Exception

object BotResponse {

    fun basicResponse(message: String): String{

        val random = (0..2).random()
        val message = message.toLowerCase()

        return when{

            //Hello
            message.contains("hello") -> {
                when (random){
                    0 -> "Hello there!"
                    1 -> "Sup"
                    2 -> "Buongiorno!"
                    else -> "error"
                }
            }

            //How Are You
            message.contains("how are you") -> {
                when (random){
                    0 -> "Finee"
                    1 -> "Hungry"
                    2 -> "Pretty good"
                    else -> "error"
                }
            }


            //Solve Math
            message.contains("solve") -> {
                val equation: String? = message.substringAfter("solve")

                return try {
                    val answer = SolveMath.solveMath(equation ?: "0")
                    answer.toString()

                } catch (e: Exception){
                    "Sorry, I can't solve that!"
                }
            }

            //Get Current Time
            message.contains("time") && message.contains("?") -> {
                Time.timeStamp()
            }

            //Open Google
            message.contains("open") && message.contains("google") -> {
                OPEN_GOOGLE
            }

            //Open Google
            message.contains("search") -> {
                OPEN_SEARCH
            }

            else -> {
                when (random){
                    0 -> "I dont understand"
                    1 -> "Idk"
                    2 -> "Try asking me something different!"
                    else -> "error"
                }
            }

        }

    }

}