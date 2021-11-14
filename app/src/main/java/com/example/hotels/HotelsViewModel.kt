package com.example.hotels

import androidx.lifecycle.ViewModel
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import android.content.res.AssetManager


class HotelsViewModel(asset: AssetManager): ViewModel() {

    val asset = asset
    lateinit var hotelAvailabilities: HotelAvailabilities

    // todo would need to ensure data refreshed when it changes
    init {
        val mapper = ObjectMapper()
        // Ignore "total" and other keywords
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        hotelAvailabilities = mapper.readValue(loadJson(), HotelAvailabilities::class.java)
    }

    private fun loadJson(): String {
        val fileName = "hotelAvailabilities.json"
        // https://stackoverflow.com/questions/9544737/read-file-from-assets
        // Note that 'use' will close the input stream after executing block function
        return asset.open(fileName).bufferedReader().use { it.readText() }
    }
}