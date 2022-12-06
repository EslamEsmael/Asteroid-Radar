package com.eslam.asteroidradar.presentation.mainFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.eslam.asteroidradar.data.model.Asteroid
import com.eslam.asteroidradar.databinding.ItemAsteroidBinding

class AsteroidsAdapter(private val itemClick: (Asteroid) -> Unit) :
    ListAdapter<Asteroid, AsteroidsAdapter.ViewHolder>(DiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemAsteroidBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val asteroid = getItem(position)
        holder.itemView.setOnClickListener {
            itemClick(asteroid)
        }
        holder.bind(asteroid)
    }

    class ViewHolder(private val viewDataBinding: ItemAsteroidBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {
        fun bind(asteroid: Asteroid) {
            viewDataBinding.asteroid = asteroid
            viewDataBinding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Asteroid>() {
        override fun areItemsTheSame(oldItem: Asteroid, newItem: Asteroid): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Asteroid, newItem: Asteroid): Boolean {
            return oldItem.id == newItem.id
        }
    }


}