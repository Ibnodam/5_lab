package com.example.a5_lab

class color(var red: Int?, var green: Int?, var blue: Int?) {

    fun setColor(): List<Int> {
        if (red == null) red = 0
        else if(red!! > 255) red = 255

        if (green == null) green = 0
        else if(green!! > 255) green = 255

        if (blue == null) blue = 0
        else if(blue!! > 255) blue = 255

        val ar:List<Int> = listOf(red!!, green!!, blue!!)

    return ar
    }
}
