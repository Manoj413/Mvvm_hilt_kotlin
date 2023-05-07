package com.example.apimultiplecall.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apimultiplecall.MainActivity
import com.example.apimultiplecall.Models.Results
import com.example.apimultiplecall.R

class ResultAdapter(private val mList: List<Results>, private val mainActivity: MainActivity) : RecyclerView.Adapter<ResultAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]
        holder.textViewName.text = ItemsViewModel.name
        holder.textViewGender.text = "Gender- "+ItemsViewModel.gender
        holder.textViewLocation.text = "Location- "+ItemsViewModel.location.name
        Glide.with(mainActivity).load(ItemsViewModel.image).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewGender: TextView = itemView.findViewById(R.id.textViewGender)
        val textViewLocation: TextView = itemView.findViewById(R.id.textViewLocation)
        val imageView : ImageView = itemView.findViewById(R.id.idImageView)
    }
}