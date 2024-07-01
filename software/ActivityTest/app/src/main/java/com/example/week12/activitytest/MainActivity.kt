package com.example.week12.activitytest

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.week12.activitytest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    val DETAIL_ACTIVITY_CODE = 100
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val dto = FoodDto(R.mipmap.ic_launcher, "치킨", 10)
            val intent = Intent(this, DetailActivity::class.java)
//            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel: 012-3456-7890"))
//            intent.putExtra("subject", "mobile software")
            intent.putExtra("food", dto)
//            startActivity(intent)

            startActivityForResult(intent, DETAIL_ACTIVITY_CODE)
        }
    }

    override fun startActivityForResult(intent: Intent, requestCode: Int, data: Intent?) {
        when(requestCode) {
            DETAIL_ACTIVITY_CODE -> {
                if(requestCode == RESULT_OK) {
                    val result = data?.getStringExtra("result_data")
                    Toast.makeText(this, "Result: $result", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}