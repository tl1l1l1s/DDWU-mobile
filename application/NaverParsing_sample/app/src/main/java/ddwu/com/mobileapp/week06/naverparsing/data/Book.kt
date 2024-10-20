package ddwu.com.mobileapp.week06.naverparsing.data

data class Book (
    var title: String?,
    var author: String?,
    var publisher: String?,
    var image: String?
) {
    override fun toString(): String {
        return "[$title ($author)]"
    }
}