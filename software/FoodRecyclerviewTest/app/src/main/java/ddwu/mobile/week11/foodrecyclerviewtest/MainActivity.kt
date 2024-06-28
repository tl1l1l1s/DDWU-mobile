package ddwu.mobile.week11.foodrecyclerviewtest

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ddwu.mobile.week11.foodrecyclerviewtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val foods = FoodDao().foods
        val adapter = FoodAdapter(foods)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter

        val listener = object : FoodAdapter.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {

            }
        }
        adapter.setOnItemClickListener(listener)

        val longListener = object : FoodAdapter.OnItemLongClickListener {
            override fun onItemLongClick(view: View, position: Int): Boolean {
                val builder : AlertDialog.Builder = AlertDialog.Builder(this@MainActivity).apply {
                    setMessage("해당 음식을 삭제하시겠습니까?")
                    setPositiveButton("예") { dialogInterfcae: DialogInterface?, i: Int ->
                        foods.removeAt(position)
                        adapter.notifyDataSetChanged()
                    }
                    setNegativeButton("아니요", null)
                    setCancelable(false)
                }

                builder.show()

                return true
            }
        }

        adapter.setOnItemLongClickListener(longListener)

        binding.button.setOnClickListener {
            val editText = binding.editTextText


            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(binding.main.windowToken, 0)

            foods.add(FoodDto(R.drawable.food01, editText.text.toString(), 10))
            adapter.notifyDataSetChanged()
            editText.setText("")
        }
    }
}