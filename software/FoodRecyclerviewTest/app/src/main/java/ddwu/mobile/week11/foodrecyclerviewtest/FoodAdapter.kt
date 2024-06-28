package ddwu.mobile.week11.foodrecyclerviewtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ddwu.mobile.week11.foodrecyclerviewtest.databinding.ListItemBinding

class FoodAdapter (val foods: ArrayList<FoodDto>) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder> (){

    override fun getItemCount() = foods.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val itemBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.itemBinding.ivPhoto.setImageResource( foods[position].photo )
        holder.itemBinding.tvFood.text = foods[position].food
        holder.itemBinding.tvCount.text = foods[position].count.toString()
    }

    inner class FoodViewHolder(val itemBinding: ListItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        val TAG = "dsdsd"

        init {
            itemBinding.root.setOnClickListener {
                listener.onItemClick(it, adapterPosition)
            }

            itemBinding.root.setOnLongClickListener {
                longListener.onItemLongClick(it, adapterPosition)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int) : Unit
    }

    interface OnItemLongClickListener {
        fun onItemLongClick(view: View, position: Int) : Boolean
    }

    lateinit var listener : OnItemClickListener

    fun setOnItemClickListener (listener: OnItemClickListener) {
        this.listener = listener
    }

    lateinit var longListener: OnItemLongClickListener

    fun setOnItemLongClickListener (listener: OnItemLongClickListener) {
        this.longListener = listener
    }
}