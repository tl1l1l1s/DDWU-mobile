package com.example.week07.dialogtest

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.week07.dialogtest.databinding.ActivityMainBinding
import com.example.week07.dialogtest.databinding.DialogLayoutBinding

class MainActivity : AppCompatActivity() {
    val mainBinding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    var selectedIdx = 0
    var selectedItems = booleanArrayOf(false, false, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

        mainBinding.button.setOnClickListener {
            val onOnClick = object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(this@MainActivity, "확인!", Toast.LENGTH_LONG).show()
                }
            }

            val dialogBinding = DialogLayoutBinding.inflate(layoutInflater) // java 객체로 만들어짐

            val builder : AlertDialog.Builder = AlertDialog.Builder(this).apply {
//                title = ""
//                setMessage("")

//                setItems(R.array.food){dlgInterface: DialogInterface?, idx: Int ->
//                    val foods = resources.getStringArray(R.array.food)
//                    Toast.makeText(this@MainActivity, foods[idx], Toast.LENGTH_LONG)
//                    Log.d("MainActivity", "${foods[idx]}")
//                }

//                setSingleChoiceItems(R.array.food, selectedIdx){dlgInterface: DialogInterface?, idx: Int ->
//                    selectedIdx = idx
//                }

//                setMultiChoiceItems(R.array.food, selectedItems) {dlgInterface: DialogInterface?, idx:Int, isChecked: Boolean ->
//                    selectedItems[idx] = isChecked
//                }

                setView(dialogBinding.root)
                setIcon(R.mipmap.ic_launcher_round)
                setPositiveButton("확인") { dlgInterface:DialogInterface?, which:Int ->
                    Log.d("MainActivity", "${dialogBinding.etProduct.text}")
                }

//                {dlgInterface: DialogInterface?, idx: Int ->
//                    val foods = resources.getStringArray(R.array.food)
//                    Log.d("MainActivity", "${selectedItems.toList()}")
//                }
                setNeutralButton("대기", null)
                setNegativeButton("취소", null)
                setCancelable(false)
            }
            builder.show()
        }
    }
}