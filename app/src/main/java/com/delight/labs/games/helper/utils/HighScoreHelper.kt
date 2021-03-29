package com.delight.labs.games.helper.utils

import android.content.Context
import android.content.SharedPreferences
import com.delight.labs.games.helper.Constants.PREFS_GLOBAL
import com.delight.labs.games.helper.Constants.PREF_TOP_SCORE

fun getPreferences(context: Context): SharedPreferences {
    return context.getSharedPreferences(
        PREFS_GLOBAL, Context.MODE_PRIVATE
    )
}

//  Setters and getters for global preferences
fun isTopScore(context: Context, newScore: Int): Boolean {
    val topScore = getPreferences(context).getInt(PREF_TOP_SCORE, 0)
    return newScore > topScore
}

fun getTopScore(context: Context): Int {
    return getPreferences(context).getInt(PREF_TOP_SCORE, 0)
}

fun setTopScore(context: Context, score: Int) {
    val editor = getPreferences(context).edit()
    editor.putInt(PREF_TOP_SCORE, score)
    editor.apply()
}