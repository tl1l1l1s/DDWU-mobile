package ddwu.com.mobileapp.week07.retrofittest.data.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


// @Get:  kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json
// @Query:  key
// @Query:  targetDt

interface IBoxOfficeService {
    @GET("kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.{type}")
    suspend fun getDailyBoxOffice(
        @Path("type") type: String,
        @Query("key") key: String,
        @Query("targetDt") targetDt: String
//    ) : Call<Root>
    ) : Root
}