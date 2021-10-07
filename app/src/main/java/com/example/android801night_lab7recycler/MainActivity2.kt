package com.example.android801night_lab7recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android801night_lab7recycler.data.DogsListAdapter
import com.example.android801night_lab7recycler.dto.DogResponse
import com.example.android801night_lab7recycler.network.ApiAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import java.lang.Exception


lateinit var etDog: EditText
lateinit var btnSearch: Button
private lateinit var adapter:DogsListAdapter
private lateinit var layoutManager: RecyclerView.LayoutManager
private lateinit var myRecyclerView: RecyclerView
private lateinit var dogList:List<String>



class MainActivity2 : AppCompatActivity(), CoroutineScope by MainScope() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        dogList = ArrayList()
        myRecyclerView = findViewById(R.id.myRecyclerViewDogs)

        //layoutManager = LinearLayoutManager(this)
        //myRecyclerView.layoutManager = layoutManager
        //adapter = DogsListAdapter(dogList, this)
        //myRecyclerView.adapter = adapter
        etDog = findViewById(R.id.etDog)
        btnSearch = findViewById(R.id.btnSearch)
        btnSearch.setOnClickListener{searchDog()}
    }


    fun searchDog() {
        if (etDog.text.toString() == "") {
            Toast.makeText(this, "Debe digitar una raza", Toast.LENGTH_SHORT).show()
            return
        }

        launch()
        {
            try {
                val apiResponse = ApiAdapter.apiClient.getListOfPet(etDog.text.toString())
                if (apiResponse.isSuccessful && apiResponse.body() != null) {
                    val dogs = apiResponse.body() as DogResponse
                    initRecycler(dogs)
                    Log.v("APIDATA", "Data: ${dogs}")
                } else {
                    Log.v("APIDATA", "No se encontro esa raza")
                }
            } catch (e: Exception) {
                Log.v("APIDATA", "Exception: ${e.localizedMessage}")
            }

        }

    }

    fun initRecycler(dogs: DogResponse)
    {
        if(dogs.status=="Success"){
            dogList = dogs.message
        }

        layoutManager = LinearLayoutManager(this)
        myRecyclerView.layoutManager = layoutManager

        adapter = DogsListAdapter(dogList, this)
        myRecyclerView.adapter = adapter

        //adapter.notifyDataSetChanged()

    }

}
