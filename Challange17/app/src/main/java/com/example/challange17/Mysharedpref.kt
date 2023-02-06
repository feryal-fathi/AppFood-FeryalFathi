package com.example.challange17

import android.content.Context

class Mysharedpref(context: Context) {
    companion object{
        private const val FILE_KEY="user_info"
        private const val FONT_SIZE="font_size"
    }
    private val sharedpref=context.getSharedPreferences(FILE_KEY,Context.MODE_PRIVATE)

    fun saveFontSiza(size: Float)
    {
        sharedpref.edit().putFloat(FONT_SIZE,size)
            .apply()
    }

    fun getFontSize():Float?
    {
        return sharedpref.getFloat(FONT_SIZE,0f)
    }

}