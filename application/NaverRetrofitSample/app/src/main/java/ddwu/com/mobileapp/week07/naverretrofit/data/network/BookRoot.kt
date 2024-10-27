package ddwu.com.mobileapp.week07.naverretrofit.data.network

import com.google.gson.annotations.SerializedName


// BookRoot
data class Root(
    val lastBuildDate: String,
    val total: Long,
    val start: Long,
    val display: Long,
    @SerializedName("items") val books: List<Book>,
)

data class Book(
    val title: String,
    val link: String,
    val image: String,
    val author: String,
    val discount: String,
    val publisher: String,
    val pubdate: String,
    val isbn: String,
    val description: String,
)

// Book dto (item 저장)


// Book의 toString() 참고
/*
    override fun toString(): String {
        return "$title - $author"
    }
*/

