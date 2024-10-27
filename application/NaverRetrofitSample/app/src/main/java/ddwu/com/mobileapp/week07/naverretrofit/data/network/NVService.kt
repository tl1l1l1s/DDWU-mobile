package ddwu.com.mobileapp.week07.naverretrofit.data.network

import android.content.Context
import android.graphics.Bitmap
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.FutureTarget
import com.bumptech.glide.request.target.CustomTarget
import ddwu.com.mobileapp.week07.naverretrofit.R
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class NVService(val context: Context) {
    private val TAG = "NVService"
    private val service : INaverBookSearch

    init {
        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(context.resources.getString(R.string.url))
            .addConverterFactory( GsonConverterFactory.create())
            .build()

        service = retrofit.create(INaverBookSearch::class.java)
    }


    fun getBooks(query: String, clientID: String, clientSecret: String) : List<Book>? {
        val root : Root = service.getBooks("json", clientID, clientSecret, query)

        return root.books
    }


//    fun getImage(url: String?) : Bitmap? {
//
//
//        return null
//    }

}