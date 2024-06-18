package ddwu.com.mobile.finalreport

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ddwu.com.mobile.finalreport.databinding.ActivityIntroduceBinding

class IntroduceActivity : AppCompatActivity() {
    val introduceBinding by lazy {
        ActivityIntroduceBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(introduceBinding.root)

        introduceBinding.closeBtn.setOnClickListener {
            finish()
        }
    }

}