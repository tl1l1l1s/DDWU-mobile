// 과제명: 도서 관리 앱
// 분반: 02 분반
// 학번: 20200224 성명: 신윤지
// 제출일: 2024년 6월 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 내기전에확인점!
package ddwu.com.mobile.finalreport

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ddwu.com.mobile.finalreport.data.BookDao
import ddwu.com.mobile.finalreport.data.BookDto
import ddwu.com.mobile.finalreport.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val REQ_ADD = 100
    val REQ_UPDATE = 200

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    lateinit var books : ArrayList<BookDto>
    val bookDao by lazy {
        BookDao(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        books = bookDao.getAllBooks()
        val adapter = BookAdapter(books)

        val layoutManager = LinearLayoutManager(this).apply {
            orientation = LinearLayoutManager.VERTICAL
        }

        binding.rv.layoutManager = layoutManager
        binding.rv.adapter = adapter

        adapter.setOnItemClickListener (object : BookAdapter.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                val intent = Intent(this@MainActivity, UpdateActivity::class.java)
                intent.putExtra("dto", books[position])
                startActivityForResult(intent, REQ_UPDATE)
            }
        })

        adapter.setOnItemLongClickListener(object : BookAdapter.OnItemLongClickListener{
            override fun onItemLongClick(view: View, position: Int): Boolean {
                val builder : AlertDialog.Builder = AlertDialog.Builder(this@MainActivity).apply {
                    title = "도서 삭제"
                    setMessage("도서 ${books[position].name}를 삭제하시겠습니까?")
                    setPositiveButton("삭제") { dialogInterface: DialogInterface?, i: Int ->
                        if(bookDao.deleteBook(books[position]) > 0) {
                            books.clear()
                            books.addAll(bookDao.getAllBooks())
                            binding.rv.adapter?.notifyDataSetChanged()

                        }
                    }
                    setNegativeButton("취소", null)
                    setCancelable(false)
                }
                builder.show()
                return true
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.addBook -> {
                val intent = Intent(this@MainActivity, AddActivity::class.java)
                startActivityForResult(intent, REQ_ADD)
            }

            R.id.introduce -> {
                val intent = Intent(this, IntroduceActivity::class.java)
                startActivity(intent)
            }

            R.id.exit -> {
                val builder : AlertDialog.Builder = AlertDialog.Builder(this@MainActivity).apply {
                    title = "앱 종료"
                    setMessage("앱을 종료하시겠습니까?")
                    setPositiveButton("종료") { dialogInterface: DialogInterface?, i: Int ->
                        finish()
                    }
                    setNegativeButton("취소", null)
                    setCancelable(false)
                }
                builder.show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            REQ_ADD -> {
                if(resultCode == RESULT_OK) {
                    books.clear()
                    books.addAll(bookDao.getAllBooks())
                    binding.rv.adapter?.notifyDataSetChanged()
                }
            }

            REQ_UPDATE -> {
                if(resultCode == RESULT_OK) {
                    books.clear()
                    books.addAll(bookDao.getAllBooks())
                    binding.rv.adapter?.notifyDataSetChanged()
                }
            }
        }
    }

}