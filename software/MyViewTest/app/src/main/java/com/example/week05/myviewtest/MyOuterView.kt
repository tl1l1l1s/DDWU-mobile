package com.example.week05.myviewtest

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class MyOuterView : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    var x = 100;
    var y = 100;
    var r = 100;
    var color = Color.BLUE

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas?.drawColor(Color.LTGRAY)
        val paint = Paint()
        paint.setColor(color)
        canvas?.drawCircle(x.toFloat(), y.toFloat(), r.toFloat(), paint)
    }
}