package ddwu.com.mobileapp.week06.naverparsing.data.network

import android.content.Context
import android.content.res.Resources
import ddwu.com.mobileapp.week06.naverparsing.R
import ddwu.com.mobileapp.week06.naverparsing.data.Book
import ddwu.com.mobileapp.week06.naverparsing.data.network.util.NaverBookParser
import ddwu.com.mobileapp.week06.naverparsing.data.network.util.NetworkUtil
import java.io.InputStream

class NetworkService(private val context: Context) {

    fun getBooksByKeyword(keyword: String) : List<Book> {
        val params : HashMap<String, String> = HashMap()
        params["query"] = keyword

        val result : InputStream? = try {
            NetworkUtil(context).sendRequest(NetworkUtil.GET, context.resources.getString(R.string.naver_url), params)
        } catch(e: Exception) {
            e.printStackTrace()
            null
        }

        return NaverBookParser().parse(result)
    }
}