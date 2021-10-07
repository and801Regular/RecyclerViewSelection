package com.example.android801night_lab7recycler.util

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.fromUL(url:String){
    Picasso.get().load(url).into(this)
}