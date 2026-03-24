package com.infinium.infiniumweather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FavoritesLocationRecyclerViewAdapter(val city: Array<String>) : RecyclerView.Adapter<FavoritesLocationRecyclerViewAdapter.FavoriteLocationViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): FavoriteLocationViewHolder {
        return FavoriteLocationViewHolder(
            view = LayoutInflater.from(parent.context).inflate(R.layout.activity_favorites_item, parent, false)
        )
    }

    override fun onBindViewHolder(viewHolder: FavoriteLocationViewHolder, position: Int) {
        viewHolder.city.text = city[position]
    }

    override fun getItemCount(): Int {
        return city.size
    }

    class FavoriteLocationViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val city = view.findViewById<TextView>(R.id.favorite_location_tv)
    }
}