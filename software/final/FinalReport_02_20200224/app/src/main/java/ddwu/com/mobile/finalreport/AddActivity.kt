package ddwu.com.mobile.finalreport

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import ddwu.com.mobile.finalreport.data.BookDao
import ddwu.com.mobile.finalreport.data.BookDto
import ddwu.com.mobile.finalreport.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    val log = "Add"

    val addBinding by lazy {
        ActivityAddBinding.inflate(layoutInflater)
    }

    val bookDao by lazy {
        BookDao(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(addBinding.root)

        addBinding.addBtn.setOnClickListener {
            val name = addBinding.editName.text.toString()
            val author = addBinding.editAuthor.text.toString()
            val publisher = addBinding.editPublisher.text.toString()
            val price = addBinding.editPrice.text.toString()

            bookDao.addBook(BookDto(0, R.drawable.book.toString(), name, author, publisher, price))
            setResult(RESULT_OK)
            finish()
        }

        addBinding.cancelBtn.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}