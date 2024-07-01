package com.example.week12.activitytest

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.week12.activitytest.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    val TAG = "DetailActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val data = intent.getStringExtra("subject")
        Log.d(TAG, "Subject: $data")
    }
}