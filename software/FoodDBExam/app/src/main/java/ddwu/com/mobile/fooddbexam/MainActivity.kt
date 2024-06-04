package ddwu.com.mobile.fooddbexam

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns
import android.util.Log
import ddwu.com.mobile.fooddbexam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    val ADD_ACTIVITY_CODE = 100
    val REMOVE_ACTIVITY_CODE = 200
    val UPDATE_ACTIVITY_CODE = 300

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    lateinit var helper : FoodDBHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        helper = FoodDBHelper(this)
       // val db = helper.readableDatabase

        binding.btnSelect.setOnClickListener{
            val foodList = showFoods()

            var data = ""

            for(food in foodList) {
                data += food.toString() + "\n"
            }
            binding.tvDisplay.text = data
            binding.textView2.text
        }



        binding.btnAdd.setOnClickListener{
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }

        binding.btnUpdate.setOnClickListener{
            modifyFood()
        }

        binding.btnRemove.setOnClickListener{
            deleteFood()
        }

    }

    fun modifyFood() {
        val db = helper.writableDatabase
        val updateRow = ContentValues()
        updateRow.put("country", "한국")
        val whereClause = "food=?"
        val whereArgs = arrayOf("된장찌개")
        db.update("food_table", updateRow, whereClause, whereArgs)
        helper.close()
    }

    fun deleteFood() {
        val db = helper.writableDatabase
        val whereClause = "food=?"
        val whereArgs = arrayOf("된장찌개")
        db.delete("food_table", whereClause, whereArgs)
        helper.close()
    }

    @SuppressLint("Range")
    fun showFoods() : List<FoodDto> {
        val db = helper.writableDatabase
        val columns = arrayOf("_id", "food", "country")
        val selection = "food=?"
        val cursor = db.query(
            "food_table", columns, selection, null, null, null, null, null,
        )

        val foodList = arrayListOf<FoodDto>()

        with(cursor) {
            while(moveToNext()) {
                val id = getInt( getColumnIndex(BaseColumns._ID))
                val food = getString(getColumnIndex(FoodDBHelper.COL_FOOD))
                val country = getString (getColumnIndex(FoodDBHelper.COL_COUNTRY))
                Log.d(TAG, "$id - $food ( $country )")

                val dto = FoodDto(id, food, country)
                foodList.add(dto)
            }
        }
        cursor.close()
        helper.close()
        return foodList
    }

}