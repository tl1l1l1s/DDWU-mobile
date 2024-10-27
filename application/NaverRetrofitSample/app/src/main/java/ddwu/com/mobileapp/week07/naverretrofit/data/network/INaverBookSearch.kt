package ddwu.com.mobileapp.week07.naverretrofit.data.network

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface INaverBookSearch {
    @GET("v1/search/book.{type}")
    fun getBooks( @Path("type") type: String,
                  @Header("X-Naver-Client-Id") clientId: String,
                  @Header("X-Naver-Client-Secret") clientSecret: String,
                  @Query("query") query: String
    ) : Root
}