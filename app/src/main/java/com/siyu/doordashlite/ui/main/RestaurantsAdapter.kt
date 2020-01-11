package com.siyu.doordashlite.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.siyu.doordashlite.R
import com.siyu.doordashlite.entity.Restaurant

class RestaurantsAdapter() : RecyclerView.Adapter<RestaurantsAdapter.ViewHolder>() {

    private var restaurants = listOf<Restaurant>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.view_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val restaurant = restaurants[position]
        holder.restaurantName.text = restaurant.name
        Glide.with(holder.itemView.context)
            .load(restaurant.cover_img_url)
            .into(holder.thumbnail)
    }

    fun setData(data: List<Restaurant>) {
        this.restaurants = data
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var thumbnail: ImageView = itemView.findViewById(R.id.image_view_thumbnail)
        var restaurantName: TextView = itemView.findViewById(R.id.text_restaurant_name)
    }
}
