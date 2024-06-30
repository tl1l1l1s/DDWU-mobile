package com.example.week05.eventtest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.week05.eventtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    val mainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

        /* 익명 객체(object)로 구현 */
//        val myClick = object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                Toast.makeText(this@MainActivity, "리스너 인터페이스 구현 클래스", Toast.LENGTH_SHORT).show()
//            }
//
//        }
//
//        mainBinding.myButton.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                Toast.makeText(this@MainActivity, "익명 리스너 인터페이스 구현", Toast.LENGTH_SHORT).show()
//            }
//        })

        /* SAM 적용 */
//        mainBinding.myButton.setOnClickListener {
//            Toast.makeText(this@MainActivity, "익명 리스너 인터페이스 구현", Toast.LENGTH_SHORT).show()
//        }

        mainBinding.mainLayout.setOnLongClickListener {
            Log.d(TAG, "익명 리스너 로그 출력")
            true
        }
    }

    /*리스너 인터페이스 클래스 구현*/
//        val myClick = MyClick(this)
//        mainBinding.myButton.setOnClickListener(myClick)
//      }
//    class MyClick(val context: Context) : View.OnClickListener {
//        override fun onClick(v: View?) {
//            Toast.makeText(context, "리스너 인터페이스 구현 클래스", Toast.LENGTH_SHORT).show()
//        }

    /* Activity가 리스너 인터페이스 구현*/
//    class MainActivity : AppCompatActivity(), View.OnClickListener {
//
//        val mainBinding: ActivityMainBinding by lazy {
//            ActivityMainBinding.inflate(layoutInflater)
//        }
//
//        override fun onCreate(savedInstanceState: Bundle?) {
//            super.onCreate(savedInstanceState)
//            setContentView(mainBinding.root)
//
//            mainBinding.myButton.setOnClickListener(this)
//        }
//
//        override fun onClick(v: View?) {
//            Toast.makeText(this, "리스너 인터페이스 구현 클래스", Toast.LENGTH_SHORT).show()
//        }
    }



