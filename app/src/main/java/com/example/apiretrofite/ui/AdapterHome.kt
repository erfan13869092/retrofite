package com.example.apiretrofite.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apiretrofite.databinding.LayoutAdapterBinding

class AdapterHome(
) : RecyclerView.Adapter<AdapterHome.ViewHolder>() {
//    var task = ArrayList<ToDo>()
//        set(value) {
//            field = value
//            notifyDataSetChanged()
//        }

    inner class ViewHolder(val binding: LayoutAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int = 2

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }
}