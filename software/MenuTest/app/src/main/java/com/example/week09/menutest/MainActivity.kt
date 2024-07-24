package com.example.week09.menutest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.week09.menutest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    var selected = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerForContextMenu(binding.tvText)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
//        when(selected) {
//            0 -> {
//                menu?.findItem(R.id.subItem01)?.setChecked(true)
//            }
//            1 -> {
//                menu?.findItem(R.id.subItem02)?.setChecked(true)
//            }
//        }

        return super.onPrepareOptionsMenu(menu)
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when(item.itemId) {
//            R.id.subItem01 -> {
//                Toast.makeText(this, "01", Toast.LENGTH_SHORT).show()
//                selected = 0
//            }
//            R.id.subItem02 -> {
//                Toast.makeText(this, "02", Toast.LENGTH_SHORT).show()
//                selected = 1
//            }
//        }
//        return true
//    }

    fun onMenuClick(item: MenuItem) {
        Toast.makeText(this, "${item.title} 맛있음!", Toast.LENGTH_SHORT).show()
    }
}