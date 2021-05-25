package com.example.recyclerviewex.code.features


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerviewex.code.data.Restaurant
import com.example.recyclerviewex.databinding.ItemRestaurantBinding

class HomeFragmentAdapter : ListAdapter<Restaurant, HomeFragmentAdapter.RestaurantViewHolder>(RestaurantComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val binding = ItemRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val currentItem = getItem(position)
        if(currentItem != null) {
            holder.bind(currentItem)
        }
    }

    inner class RestaurantViewHolder(private val binding: ItemRestaurantBinding) :
            RecyclerView.ViewHolder(binding.root) {

                fun bind(restaurant: Restaurant) {
                    binding.apply {
                        Glide.with(itemView)
                                .load(restaurant.logo)
                                .into(restaurantLogo)

                        restaurantName.text = restaurant.name
                        restaurantAdress.text = restaurant.address
                        restaurantType.text = restaurant.type
                    }
                }
            }

    class RestaurantComparator : DiffUtil.ItemCallback<Restaurant>() {
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant) =
                oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant) =
                oldItem == newItem
    }
}