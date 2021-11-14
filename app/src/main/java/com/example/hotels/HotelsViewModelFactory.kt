package com.example.hotels

import android.content.res.AssetManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

// For adding asset parm to viewmodel constructor:
// https://appdevnotes.com/android-viewmodel-tutorial-for-beginners-in-kotlin/

class HotelsViewModelFactory(asset: AssetManager): ViewModelProvider.Factory{
    private val asset = asset
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HotelsViewModel::class.java)){
            return HotelsViewModel(asset) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}