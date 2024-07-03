package com.example.week05.layouttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import com.example.week05.layouttest.databinding.ActivityMainBinding
import com.example.week05.layouttest.databinding.LinearLayoutBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: LinearLayoutBinding =
            LinearLayoutBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.button.setOnClickListener {

        }


    }
}