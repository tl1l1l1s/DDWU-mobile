package ddwu.com.mobile.fooddbexam

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ddwu.com.mobile.fooddbexam.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    val addBinding by lazy {
        ActivityAddBinding.inflate(layoutInflater)
    }

    lateinit var helper : FoodDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(addBinding.root)

        addBinding.btnAddFood.setOnClickListener {
            //DB 작업 수행
            addFood(addBinding.etAddFood.text.toString(), addBinding.etAddNation.text.toString())
        }
    }


    // 기능별로 class 분산시키는 것이 나음 => DAO로 (다음 시간에)
    fun addFood(food: String, country: String) {
        val db = helper.writableDatabase
        val newRow = ContentValues()
        newRow.put(FoodDBHelper.COL_FOOD, food)
        newRow.put(FoodDBHelper.COL_COUNTRY, country)
        db.insert(FoodDBHelper.TABLE_NAME, null, newRow)
        helper.close()
    }
}