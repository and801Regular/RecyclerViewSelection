package com.example.android801night_lab7recycler.data

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.android801night_lab7recycler.R
import com.example.android801night_lab7recycler.dto.DogResponse
import com.example.android801night_lab7recycler.util.fromUL
import javax.xml.transform.URIResolver

class DogsListAdapter(private val images:List<String>, private val context: Context):
    RecyclerView.Adapter<DogsListAdapter.ViewHolder>(){


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindItem(image: String){
            var ivDog: ImageView = itemView.findViewById(R.id.imageViewDogs) as ImageView
            ivDog.fromUL(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.dog_cardview,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(images[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }


}