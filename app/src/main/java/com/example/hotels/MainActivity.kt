package com.example.hotels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper

class MainActivity : AppCompatActivity() {
    private lateinit var viewModelFactory: HotelsViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Get asset in order to read json file in asset folder
        val asset = getAssets()
        viewModelFactory = HotelsViewModelFactory(asset)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(HotelsViewModel::class.java)
        // Load data into Recycler View to display
        val hotelListView = findViewById<View>(R.id.hotel_list) as RecyclerView
        val adapter = HotelAdapter(viewModel.hotelAvailabilities)
        hotelListView.adapter = adapter
        hotelListView.layoutManager = LinearLayoutManager(applicationContext)

    }

}