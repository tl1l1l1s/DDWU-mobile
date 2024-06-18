package ddwu.com.mobile.finalreport.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import ddwu.com.mobile.finalreport.R

class BookDBHelper(context: Context?) : SQLiteOpenHelper(context, DB_NAME, null, 1) {
    companion object {
        const val DB_NAME = "book_db"
        const val TABLE_NAME = "book_table"
        const val COL_IMAGE = "image"
        const val COL_NAME = "name"
        const val COL_AUTHOR = "author"
        const val COL_PUBLISHER = "publisher"
        const val COL_PRICE = "price"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE =
            "CREATE TABLE ${TABLE_NAME} (${ BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "${COL_IMAGE} TEXT, ${COL_NAME} TEXT, ${COL_AUTHOR} TEXT, ${COL_PUBLISHER} TEXT, ${COL_PRICE} TEXT )"
        db?.execSQL(CREATE_TABLE)

        /*샘플 데이터*/
        db?.execSQL("INSERT INTO $TABLE_NAME VALUES (NULL, ${R.drawable.book1.toString()}, '물고기는 존재하지 않는다', '룰루 밀러', '곰출판', '17,000')")
        db?.execSQL("INSERT INTO $TABLE_NAME VALUES (NULL, ${R.drawable.book2.toString()}, '도둑맞은 집중력', '요한 하리', '어크로스', '18,000')")
        db?.execSQL("INSERT INTO $TABLE_NAME VALUES (NULL, ${R.drawable.book3.toString()}, '트렌드 코리아 2024', '김난도 외 10명', '미래의창', '19,000')")
        db?.execSQL("INSERT INTO $TABLE_NAME VALUES (NULL, ${R.drawable.book4.toString()}, 'A Little Life', 'Hanya Yanagihara', '시공사', '14,800')")
        db?.execSQL("INSERT INTO $TABLE_NAME VALUES (NULL, ${R.drawable.book.toString()}, '샘플북', '지은이', '출판사', '9,999')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val DROP_TABLE = "DROP TABLE IF EXISTS ${TABLE_NAME}"
        db?.execSQL(DROP_TABLE)
        onCreate(db)
    }
}