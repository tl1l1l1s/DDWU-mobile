package ddwu.com.mobile.foodexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ddwu.com.mobile.foodexam.databinding.ActivityAddFoodBinding
import java.io.Serializable

class AddFoodActivity : AppCompatActivity() {
    val TAG = "AddFoodActivity"
    val binding by lazy {
        ActivityAddFoodBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val resultIntent = Intent()

        binding.btnSave.setOnClickListener {
            val foodData = FoodDto(binding.etNewFood.text.toString(), binding.etCountry.text.toString())
            resultIntent.putExtra("result_data", foodData)
            setResult(RESULT_OK, resultIntent)
            finish()
        }

        binding.btnCancel.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }


}