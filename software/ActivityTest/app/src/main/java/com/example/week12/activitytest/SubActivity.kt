package com.example.week12.activitytest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.week12.activitytest.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    val binding by lazy {
        ActivitySubBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}