package com.example.retrofitmvvmpractice.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitmvvmpractice.R
import com.example.retrofitmvvmpractice.model.Placeholder
import kotlinx.android.synthetic.main.item_placeholder.view.*

class PlaceholderListAdapter(var placeholders:ArrayList<Placeholder>):RecyclerView.Adapter<PlaceholderListAdapter.PlaceholderViewHolder>() {

    fun updateCountries(newPlaceholders:List<Placeholder>){
        placeholders.clear()
        placeholders.addAll(newPlaceholders)
        notifyDataSetChanged()
    }

    class PlaceholderViewHolder(view: View): RecyclerView.ViewHolder(view){
        val placeholderName=view.name
        fun bind(placeholder: Placeholder){
            placeholderName.text=placeholder.name

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceholderViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_placeholder,parent,false)
        return PlaceholderViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlaceholderViewHolder, position: Int) {
        holder.bind(placeholders[position])
    }

    override fun getItemCount(): Int =placeholders.size
}