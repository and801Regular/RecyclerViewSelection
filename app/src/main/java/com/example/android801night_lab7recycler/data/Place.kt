package com.example.android801night_lab7recycler.data

class Place() {
    var CountryName: String?=null
    var CityName: String?=null

    constructor( country:String, city :String) : this() {
        CountryName = country
        CityName= city
    }
}