package ddwu.com.mobile.finalreport.data

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.provider.BaseColumns
import ddwu.com.mobile.finalreport.R

class BookDao(val context: Context) {

    @SuppressLint("Range")
    fun getAllBooks(): ArrayList<BookDto> {
        val helper = BookDBHelper(context)
        val db = helper.readableDatabase
        val cursor = db.query(BookDBHelper.TABLE_NAME, null, null, null, null, null, null)

        val books = arrayListOf<BookDto>()
        with(cursor) {
            while(moveToNext()) {
                val id = getInt( getColumnIndex(BaseColumns._ID))
                val image = getString(getColumnIndex(BookDBHelper.COL_IMAGE))
                val name = getString(getColumnIndex(BookDBHelper.COL_NAME))
                val author = getString(getColumnIndex(BookDBHelper.COL_AUTHOR))
                val publisher = getString(getColumnIndex(BookDBHelper.COL_PUBLISHER))
                val price = getString(getColumnIndex(BookDBHelper.COL_PRICE))
                val dto = BookDto(id, image, name, author, publisher, price)
                books.add(dto)
            }
        }
        cursor.close()
        helper.close()
        return books
    }

    fun addBook(dto: BookDto) {
        val helper = BookDBHelper(context)
        val db = helper.writableDatabase
        val newRow = ContentValues()
        newRow.put("image", dto.photo)
        newRow.put("name", dto.name)
        newRow.put("author", dto.author)
        newRow.put("publisher", dto.publisher)
        newRow.put("price", dto.price)
        db.insert("book_table",null, newRow)
        helper.close()
    }

    fun updateBook(dto: BookDto) : Int {
        val helper = BookDBHelper(context)
        val db = helper.writableDatabase
        val updateRow = ContentValues()
        updateRow.put("name", dto.name)
        updateRow.put("author", dto.author)
        updateRow.put("publisher", dto.publisher)
        updateRow.put("price", dto.price)
        val whereClause = "${BaseColumns._ID}=?"
        val whereArgs = arrayOf(dto.id.toString())
        val count = db.update("book_table", updateRow, whereClause, whereArgs)
        helper.close()
        return count
    }

    fun deleteBook(dto: BookDto) : Int {
        val helper = BookDBHelper(context)
        val db = helper.writableDatabase
        val whereClause = "${BaseColumns._ID}=?"
        val whereArgs = arrayOf(dto.id.toString())
        val count = db.delete("book_table", whereClause, whereArgs)
        helper.close()
        return count
    }
}