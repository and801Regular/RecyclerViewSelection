package com.example.android801night_lab7recycler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android801night_lab7recycler.data.Place
import com.example.android801night_lab7recycler.data.PlaceListAdapter

private var adapter:PlaceListAdapter?=null
private var countryList:ArrayList<Place>?=null
private var layoutManager:RecyclerView.LayoutManager?=null

lateinit  var tv:TextView

private lateinit var myRecyclerView: RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var total : Int = 0
        var selected: Int = 0
        tv = findViewById(R.id.textView)
        countryList= ArrayList<Place>()
        layoutManager=LinearLayoutManager(this)
        adapter = PlaceListAdapter(countryList!!,this, onCheckChange)

        myRecyclerView = findViewById(R.id.myRecyclerView)
        myRecyclerView.layoutManager= layoutManager
        myRecyclerView.adapter= adapter
        myRecyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        tv.text= "$selected de $total"

        val buttonNext : Button = findViewById(R.id.buttonNext)
        buttonNext.setOnClickListener { onClickNext() }




        //Load data
        var countryNameList : Array<String> = arrayOf("Canada","USA","Mexico","Colombia","Malasya","Singapore","Turkey","Nicaragua",
            "India","Italy","Tunissia","Chile","Argentina","Spain","Peru")

        var cityNameList : Array<String> = arrayOf("Otawa","Washington D.C.","Mexico City","Bogota","Kuala Lumpur","Singapore","Ankara","Managua",
            "New Delhi","Roma","Tunis","Santiago","Buenos Aires","Madrid","Lima")

        for(i in 0..countryNameList.size-1){
            var place=Place( countryNameList[i],cityNameList[i])
            countryList?.add(place)
        }
        adapter!!.notifyDataSetChanged()
        tv.text= "$selected de ${adapter!!.itemCount}"

    }

    fun onClickNext(){
        intent = Intent(this,MainActivity2::class.java)
        startActivity(intent)
    }

    val onCheckChange: (Int, Int) -> Unit = { selected, total ->
        tv.text= "$selected de $total"
    }
}