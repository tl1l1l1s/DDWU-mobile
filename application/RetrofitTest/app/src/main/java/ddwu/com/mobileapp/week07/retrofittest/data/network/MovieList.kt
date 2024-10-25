package ddwu.com.mobileapp.week07.retrofittest.data.network

import com.google.gson.annotations.SerializedName

/*data class 를 사용하여 DTO 작성*/
data class Root(
    @SerializedName("boxOfficeResult")
    val movieResult: BoxOfficeResult,
)

data class BoxOfficeResult(
    val boxofficeType: String,
    val showRange: String,
    @SerializedName("dailyBoxOfficeList")
    val movieList: List<Movie>,
)

data class Movie(
    val rank: String,
    @SerializedName("movieNm") val title: String,
    @SerializedName("openDt") val openDate: String,
)
