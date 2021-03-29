package com.delight.labs.games.helper.utils

import android.content.Context
import android.util.TypedValue

fun pixelsToDp(px: Int, context: Context): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, px.toFloat(), context.resources.displayMetrics
    ).toInt()
}