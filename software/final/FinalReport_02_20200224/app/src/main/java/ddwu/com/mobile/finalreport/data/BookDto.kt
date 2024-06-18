package ddwu.com.mobile.finalreport.data

import java.io.Serializable

class BookDto(val id: Int, val photo: String, var name: String, var author: String, var publisher: String, var price: String) :
    Serializable {

    override fun toString() = "$id : $name, $author($publisher, $price)"
}