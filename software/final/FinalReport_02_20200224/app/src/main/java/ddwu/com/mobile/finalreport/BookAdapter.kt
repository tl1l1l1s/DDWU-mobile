package ddwu.com.mobile.finalreport

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ddwu.com.mobile.finalreport.data.BookDto
import ddwu.com.mobile.finalreport.databinding.ListItemBinding

class BookAdapter (val books: ArrayList<BookDto>) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    override fun getItemCount(): Int = books.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.photo.setImageResource(books[position].photo.toInt())
        holder.name.text = books[position].name
        holder.author.text = books[position].author
        holder.price.text = books[position].price
    }

    inner class BookViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val photo = binding.ivPhoto
        val name = binding.tvName
        val author = binding.tvAuthor
        val price = binding.tvPrice

        init {
            /*RecyclerView 항목 클릭 시 외부 click 이벤트 리스너 호출*/
            binding.root.setOnClickListener{
                listener?.onItemClick(it, adapterPosition)  // RecyclerView 항목 클릭 시 외부에서 지정한 리스너 호출
            }

            binding.root.setOnLongClickListener {
                val result = longClickListener?.onItemLongClick(it, adapterPosition)
                true
            }
        }
    }

    var listener : OnItemClickListener? = null
    interface OnItemClickListener {
        fun onItemClick(view : View, position : Int)
    }
    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }

    interface OnItemLongClickListener {
        fun onItemLongClick(view: View, position: Int):Boolean
    }
    var longClickListener: OnItemLongClickListener? = null
    fun setOnItemLongClickListener(listener: OnItemLongClickListener?) {
        this.longClickListener = listener
    }
}