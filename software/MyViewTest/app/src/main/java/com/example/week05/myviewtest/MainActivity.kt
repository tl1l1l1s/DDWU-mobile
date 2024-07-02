package com.example.week05.myviewtest

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week05.myviewtest.databinding.ActivityMainBinding
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val myView = MyView(this)
        val binding : ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val random = Random()
            binding.myOuterView.x = random.nextInt(500)
            binding.myOuterView.y = random.nextInt(500)
            binding.myOuterView.r = (random.nextInt(2) + 1) * 100
            binding.myOuterView.color = Color.MAGENTA
            binding.myOuterView.invalidate()
        }
    }

//    class MyView(context: Context?) : view(context) {
//        override fun onDraw(canvas: Canvas?) {
//            super.onDraw(canvas)
//            val paint = Paint()
//            paint.setColor(Color.BLUE)
//            canvas?.drawCircle(200.toFloat(), 200.toFloat(), 100.toFloat(), paint)
//        }
//    }
}