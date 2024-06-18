package ddwu.com.mobile.finalreport

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ddwu.com.mobile.finalreport.data.BookDao
import ddwu.com.mobile.finalreport.data.BookDto
import ddwu.com.mobile.finalreport.databinding.ActivityUpdateBinding

class UpdateActivity : AppCompatActivity() {
    val updateBinding by lazy {
        ActivityUpdateBinding.inflate(layoutInflater)
    }

    val bookDao by lazy {
        BookDao(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(updateBinding.root)

        /*RecyclerView 에서 선택하여 전달한 dto 를 확인*/
        val dto = intent.getSerializableExtra("dto") as BookDto

        updateBinding.imageView.setImageResource(dto.photo.toInt())
        updateBinding.editName.setText(dto.name)
        updateBinding.editAuthor.setText(dto.author)
        updateBinding.editPublisher.setText(dto.publisher)
        updateBinding.editPrice.setText(dto.price)

        updateBinding.updateBtn.setOnClickListener{
            dto.name = updateBinding.editName.text.toString()
            dto.author = updateBinding.editAuthor.text.toString()
            dto.publisher = updateBinding.editPublisher.text.toString()
            dto.price = updateBinding.editPrice.text.toString()


            if (bookDao.updateBook(dto) > 0) {
                setResult(RESULT_OK)
            } else {
                setResult(RESULT_CANCELED)
            }
            finish()
        }
        updateBinding.cancelBtn.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}