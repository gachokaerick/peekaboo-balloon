package com.delight.labs.games.helper.utils

import android.content.Context
import android.content.SharedPreferences
import com.delight.labs.games.helper.Constants.EASY_TOP_SCORE
import com.delight.labs.games.helper.Constants.HARD_TOP_SCORE
import com.delight.labs.games.helper.Constants.NORMAL_TOP_SCORE
import com.delight.labs.games.helper.Constants.PREFS_GLOBAL

fun getPreferences(context: Context): SharedPreferences {
    return context.getSharedPreferences(
            PREFS_GLOBAL, Context.MODE_PRIVATE
    )
}

//  Setters and getters for global preferences
fun isTopScore(context: Context, newScore: Int, difficulty: Int): Boolean {
    val topScore = 0
    when (difficulty) {
        1 -> {
            getPreferences(context).getInt(EASY_TOP_SCORE, 0)
        }
        2 -> {
            getPreferences(context).getInt(NORMAL_TOP_SCORE, 0)
        }
        3 -> {
            getPreferences(context).getInt(HARD_TOP_SCORE, 0)
        }
    }
    return newScore > topScore
}

fun getTopScore(context: Context, difficulty: Int): Int {
    return when (difficulty) {
        1 -> {
            getPreferences(context).getInt(EASY_TOP_SCORE, 0)
        }
        2 -> {
            getPreferences(context).getInt(NORMAL_TOP_SCORE, 0)
        }
        3 -> {
            getPreferences(context).getInt(HARD_TOP_SCORE, 0)
        }
        else -> {
            0
        }
    }
}

fun setTopScore(context: Context, score: Int, difficulty: Int) {
    val editor = getPreferences(context).edit()
    when (difficulty) {
        1 -> {
            editor.putInt(EASY_TOP_SCORE, score)
            editor.apply()
        }
        2 -> {
            editor.putInt(NORMAL_TOP_SCORE, score)
            editor.apply()
        }
        3 -> {
            editor.putInt(HARD_TOP_SCORE, score)
            editor.apply()
        }
    }
}