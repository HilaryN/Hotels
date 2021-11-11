package com.example.hotels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mapper = ObjectMapper()
        // Ignore "total" and other keywords
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        val hotelAvailabilities: HotelAvailabilities = mapper.readValue(LoadJson(), HotelAvailabilities::class.java)
        //val test = hotelAvailabilities
    }

    fun LoadJson(): String {
        var fileName = "hotelAvailabilities.json"
        // https://stackoverflow.com/questions/9544737/read-file-from-assets
        // Note that 'use' will close the input stream after executing block function
        return assets.open(fileName).bufferedReader().use { it.readText() }
    }
}