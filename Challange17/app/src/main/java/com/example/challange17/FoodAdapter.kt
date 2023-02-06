package com.example.recycleview

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.challange17.Food
import com.example.challange17.databinding.FoodItemBinding


/**
 * Created by Taha Ben Ashur (https://github.com/tahaak67) on 02,Feb,2023
 */

class FoodAdapter : ListAdapter<Food,RecyclerView.ViewHolder>(DIFF_CALLBACK) {
   var s=0f
    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Food>() {

            override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
                return oldItem.name == newItem.name && oldItem.imageUrl == newItem.imageUrl
            }

        }
    }

    private lateinit var binding: FoodItemBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        binding = FoodItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder){
            val item = getItem(position)
            holder.bind(item)
        }
    }

    inner class ViewHolder(val itemBinding: FoodItemBinding):
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Food){

            itemBinding.textView.text = item.name
            itemBinding.textView.textSize=s
            itemBinding.textView.setOnClickListener {
                Toast.makeText(it.context,"name: ${item.name}",Toast.LENGTH_LONG).show()
            }
            itemBinding.imageview.setImageResource(item.imageUrl)
        }
    }
}