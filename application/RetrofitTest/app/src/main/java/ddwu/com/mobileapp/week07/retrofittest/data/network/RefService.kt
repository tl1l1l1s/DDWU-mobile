package ddwu.com.mobileapp.week07.retrofittest.data.network

import android.content.Context
import android.util.Log
import ddwu.com.mobileapp.week07.retrofittest.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RefService(val context: Context) {
    val TAG = "RefService"
    val movieService: IBoxOfficeService

    init {
        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(context.resources.getString(R.string.kobis_url))
            .addConverterFactory( GsonConverterFactory.create() )
            .build()


        movieService = retrofit.create(IBoxOfficeService::class.java)
    }

    suspend fun getMovies(key: String, date: String)  : List<Movie>?   {
//        val movieCallback = object : Callback<Root> {
//            override fun onResponse(call: Call<Root>, response: Response<Root>) {
//                if (response.isSuccessful) {
//                    val boxOfficeRoot = response.body()
//                    val movies = boxOfficeRoot?.movieResult?.movieList
//                    movies?.forEach { movie ->
//                        Log.d(TAG, movie.toString())
//                    }
//                }
//            }
//            override fun onFailure(call: Call<Root>, t: Throwable) {
//                Log.d(TAG, t.stackTraceToString())
//            }
//        }
//
//        val movieCall : Call <Root> = movieService.getDailyBoxOffice("json", key, date)
//        movieCall.enqueue(movieCallback)    // val response = movieCall.execute()
//
//        return null // response.body()?.boxOfficeResult?.boxOfficeList

//      Retrofit에서 자체 지원하는 비동기 처리(coroutine) 사용 시 call 및 callback 대체 가능
        val root : Root = movieService.getDailyBoxOffice("json", key, date)

        return root.movieResult.movieList
    }

}