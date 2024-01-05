package com.example.apiretrofite.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apiretrofite.data.model.ParentCoinItem
import com.example.apiretrofite.databinding.LayoutAdapterBinding

class AdapterHome(
) : RecyclerView.Adapter<AdapterHome.ViewHolder>() {
    var coins = ArrayList<ParentCoinItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ViewHolder(val binding: LayoutAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(parentCoinItem: ParentCoinItem) {
            binding.checkedTextView.text=parentCoinItem.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int = coins.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(coins[position])
    }
}