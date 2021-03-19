package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {

    private val _shoesList = MutableLiveData<MutableList<Shoe>>()
    val shoeList : LiveData<MutableList<Shoe>>
        get() = _shoesList

    init {
        val list = mutableListOf(Shoe("one", 36.0, "comp1", "nice shoe1", emptyList()),
            Shoe("two", 39.0, "comp3", "nice shoe2", emptyList()),
            Shoe("three", 34.0, "comp3", "nice shoe3", emptyList()))

        _shoesList.value = list
    }

    fun addShoe(newShoe : Shoe){
        _shoesList.value?.add(newShoe)
    }
}