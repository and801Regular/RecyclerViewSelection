package com.example.android801night_lab7recycler.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.android801night_lab7recycler.R

class PlaceListAdapter(private val list:ArrayList<Place>,private val context: Context,val onCheckChanged: (selected: Int, total: Int) -> Unit):RecyclerView.Adapter<PlaceListAdapter.ViewHolder>(){
 private var checkedItems = ArrayList<Place>()

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        fun bindItem(place: Place){
            var country:TextView = itemView.findViewById(R.id.country_ID) as TextView
            var city:TextView = itemView.findViewById(R.id.city_ID) as TextView
            var checkBox : CheckBox = itemView.findViewById(R.id.mycheckBox) as CheckBox
            country.text= place.CountryName
            city.text = place.CityName
            itemView.setOnClickListener{ Toast.makeText(context,country.text,Toast.LENGTH_SHORT).show()}
            checkBox.setOnClickListener{onCheckBoxClick(checkBox,place)}

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.card_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun onCheckBoxClick(view: View,place:Place){
        var myCheckBox:CheckBox= view as CheckBox
        if(myCheckBox.isChecked)
            checkedItems.add(place)
        else
            checkedItems.remove(place)
        onCheckChanged(checkedItems.size,itemCount)
        getCheckedItems()

    }

    fun getCheckedItems() {
        val count = checkedItems.size.toString()?:"0"
        Toast.makeText(context,count,Toast.LENGTH_SHORT).show()
    }
}