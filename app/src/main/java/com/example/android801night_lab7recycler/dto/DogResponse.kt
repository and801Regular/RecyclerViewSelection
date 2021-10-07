package com.example.android801night_lab7recycler.dto

import com.google.gson.annotations.SerializedName

data class DogResponse(
    @SerializedName("status") var status : String,
    var message : List<String>
)

//@SerializedName opcional para mapeas las propiedades del JSON con otro nombre
